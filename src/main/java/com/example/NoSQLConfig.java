package com.example;

import java.io.File;
import java.io.IOException;

import com.oracle.nosql.spring.data.config.AbstractNosqlConfiguration;
import com.oracle.nosql.spring.data.config.NosqlDbConfig;
import com.oracle.nosql.spring.data.repository.config.EnableNosqlRepositories;
import oracle.nosql.driver.NoSQLHandleConfig;
import oracle.nosql.driver.iam.SignatureProvider;
import com.oracle.nosql.spring.data.core.NosqlTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableNosqlRepositories
public class NoSQLConfig extends AbstractNosqlConfiguration {
    @Value("${cloud.oci.region}")
    String region;

    @Value("${cloud.oci.compartment-id}")
    String compartmentId;

    @Value("${cloud.oci.tenancy-id}")
    String tenancyId;

    @Value("${cloud.oci.user-id}")
    String userId;

    @Value("${cloud.oci.private-key-file}")
    String privateKeyFileString;

    @Value("${cloud.oci.fingerprint-of-key-file}")
    String fingerprintOfKeyFile;

    /**
     * Creates a NosqlDbConfig using the default OCI config file at ~/.oci/config
     * @see <a href="https://docs.oracle.com/en/database/other-databases/nosql-database/23.1/springsdk/setting-connection.html#GUID-CE6905E4-70FA-4C22-8AE1-48A7B36EF178">Setting up the Oracle NoSQL connection</a>
     * @return NosqlDbConfig
     * @throws IOException when the OCI config file cannot be read
     */
    @Bean
    public NosqlDbConfig nosqlDbConfig() throws IOException {
        SignatureProvider provider;
        NosqlDbConfig nosqlDbConfig;
        File privateKeyFile;
        NoSQLHandleConfig nosqlHandleConfig;
        char[] passPhrase = new char[0];

        //nosqlDbConfig = NosqlDbConfig.createCloudConfig(region, "~/.oci/config", "NOSQL");

        privateKeyFile = new File(privateKeyFileString);
        provider = new SignatureProvider(tenancyId, userId, fingerprintOfKeyFile, privateKeyFile, passPhrase);
        nosqlHandleConfig = new NoSQLHandleConfig(region, provider);
        nosqlHandleConfig.setDefaultCompartment(compartmentId);
        nosqlDbConfig = new NosqlDbConfig(nosqlHandleConfig);


        return nosqlDbConfig;
    }

}



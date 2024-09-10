package com.example;

import java.io.IOException;

import com.oracle.nosql.spring.data.config.AbstractNosqlConfiguration;
import com.oracle.nosql.spring.data.config.NosqlDbConfig;
import com.oracle.nosql.spring.data.repository.config.EnableNosqlRepositories;
import oracle.nosql.driver.iam.SignatureProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNosqlRepositories
public class NoSQLConfig extends AbstractNosqlConfiguration {
    @Value("${cloud.oci.region}")
    String region;

    /**
     * Creates a NosqlDbConfig using the default OCI config file at ~/.oci/config
     * @see <a href="https://docs.oracle.com/en/database/other-databases/nosql-database/23.1/springsdk/setting-connection.html#GUID-CE6905E4-70FA-4C22-8AE1-48A7B36EF178">Setting up the Oracle NoSQL connection</a>
     * @return NosqlDbConfig
     * @throws IOException when the OCI config file cannot be read
     */
    @Bean
    public NosqlDbConfig nosqlDbConfig() throws IOException {
        //return new NosqlDbConfig(region, new SignatureProvider());
        return NosqlDbConfig.createCloudConfig(region, "~/.oci/config", "NOSQL");
    }
}

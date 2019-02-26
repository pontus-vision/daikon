package org.talend.daikon.messages.utils;

import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.talend.daikon.messages.MessageHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Kafka headers helpers
 */
public class HeadersUtils {

    /**
     * Map @{MessageHeader} into a list of Kafka @{org.apache.kafka.common.header.Header}
     * 
     * @param messageHeader Daikon message header
     * @return List of Kafka headers
     */
    public static List<Header> generateKafkaHeaders(MessageHeader messageHeader) {
        List<Header> headers = new ArrayList<>();

        // Required
        headers.add(new RecordHeader("id", messageHeader.getId().getBytes()));
        headers.add(new RecordHeader("timestamp", messageHeader.getTimestamp().toString().getBytes()));
        headers.add(new RecordHeader("issuer.application", messageHeader.getIssuer().getApplication().getBytes()));
        headers.add(new RecordHeader("issuer.service", messageHeader.getIssuer().getService().getBytes()));
        headers.add(new RecordHeader("issuer.version", messageHeader.getIssuer().getVersion().getBytes()));
        headers.add(new RecordHeader("type", messageHeader.getType().toString().getBytes()));
        headers.add(new RecordHeader("name", messageHeader.getName().getBytes()));
        headers.add(new RecordHeader("correlationId", messageHeader.getCorrelationId().getBytes()));

        // Optional
        if (messageHeader.getTenantId() != null) {
            headers.add(new RecordHeader("tenantId", messageHeader.getTenantId().getBytes()));
        }
        if (messageHeader.getUserId() != null) {
            headers.add(new RecordHeader("userId", messageHeader.getUserId().getBytes()));
        }
        if (messageHeader.getSecurityToken() != null) {
            headers.add(new RecordHeader("securityToken", messageHeader.getSecurityToken().getBytes()));
        }
        if (messageHeader.getSchemaUri() != null) {
            headers.add(new RecordHeader("schemaUri", messageHeader.getSchemaUri().getBytes()));
        }

        return headers;
    }

}

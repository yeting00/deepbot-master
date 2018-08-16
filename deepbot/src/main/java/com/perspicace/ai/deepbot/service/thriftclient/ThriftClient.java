package com.perspicace.ai.deepbot.service.thriftclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

@Slf4j
public class ThriftClient<T extends TServiceClient> {
    private TTransport transport;
    private TProtocol protocol;
    private TMultiplexedProtocol multiplexedprotocol;
    private T client;

    @SuppressWarnings("unchecked")
    public ThriftClient(String host , int port , String serviceName) {
        transport = new TSocket ( host , port , 10 * 1000 , 10 * 1000 );
        protocol = new TBinaryProtocol ( transport );
        multiplexedprotocol = new TMultiplexedProtocol ( protocol , serviceName );
    }

    public void open() throws TTransportException {
        transport.open ( );
    }

    public void close() {
        transport.close ( );
    }

    public T getClient() {
        return this.client;
    }


    public void setClient(T Client) {
        this.client = Client;
    }

    public TMultiplexedProtocol getMultiplexedprotocol() {
        return multiplexedprotocol;
    }

    protected void finalize() {
        this.transport = null;
        this.protocol = null;
        this.multiplexedprotocol = null;
        this.client = null;
        log.info ( "ThriftClient finalize" );
    }
}

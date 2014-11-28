package com.nhn.pinpoint.profiler.modifier.redis;

import java.security.ProtectionDomain;

import com.nhn.pinpoint.bootstrap.Agent;
import com.nhn.pinpoint.bootstrap.instrument.ByteCodeInstrumentor;
import com.nhn.pinpoint.bootstrap.instrument.InstrumentClass;
import com.nhn.pinpoint.bootstrap.instrument.InstrumentException;
import com.nhn.pinpoint.bootstrap.instrument.NotFoundInstrumentException;
import com.nhn.pinpoint.bootstrap.interceptor.tracevalue.MapTraceValue;

/**
 * RedisCluster(nBase-ARC client) modifier
 * 
 * @author jaehong.kim
 *
 */
public class BinaryTriplesRedisClusterModifier extends RedisClusterModifier {

    public BinaryTriplesRedisClusterModifier(ByteCodeInstrumentor byteCodeInstrumentor, Agent agent) {
        super(byteCodeInstrumentor, agent);
    }

    @Override
    public String getTargetClass() {
        return "com/nhncorp/redis/cluster/triples/BinaryTriplesRedisCluster";
    }

    @Override
    protected void beforeAddInterceptor(ClassLoader classLoader, ProtectionDomain protectedDomain, final InstrumentClass instrumentClass) throws NotFoundInstrumentException, InstrumentException {
        // trace destinationId, endPoint
        instrumentClass.addTraceValue(MapTraceValue.class);
    }
}
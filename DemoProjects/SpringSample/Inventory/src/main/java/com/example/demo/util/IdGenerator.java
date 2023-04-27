package com.example.demo.util;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

public class IdGenerator extends UUIDGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		final String uuid = super.generate(session, object).toString();
		final long longTimeRandom = System.nanoTime() + System.currentTimeMillis() + new Random().nextLong() + Objects.hash(object);
		final String timeHex = Long.toHexString(longTimeRandom);
		return "CT"+ StringUtils.substring(timeHex, -4) + StringUtils.substring(uuid, -4);
	}

}

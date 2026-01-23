package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import com.esotericsoftware.kryo.util.Util;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers {

    public static class BigDecimalSerializer extends Serializer<BigDecimal> {
        private final BigIntegerSerializer bigIntegerSerializer = new BigIntegerSerializer();

        public BigDecimalSerializer() {
            setAcceptsNull(true);
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ BigDecimal read(Kryo kryo, Input input, Class<BigDecimal> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, BigDecimal bigDecimal) {
            write2(kryo, output, bigDecimal);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public BigDecimal read2(Kryo kryo, Input input, Class<BigDecimal> cls) {
            BigInteger bigInteger = this.bigIntegerSerializer.read2(kryo, input, BigInteger.class);
            if (bigInteger == null) {
                return null;
            }
            int i = input.readInt(false);
            if (cls == BigDecimal.class || cls == null) {
                return (bigInteger == BigInteger.ZERO && i == 0) ? BigDecimal.ZERO : new BigDecimal(bigInteger, i);
            }
            try {
                Constructor<BigDecimal> constructor = cls.getConstructor(BigInteger.class, Integer.TYPE);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    } catch (SecurityException unused) {
                    }
                }
                return constructor.newInstance(bigInteger, Integer.valueOf(i));
            } catch (Exception e) {
                throw new KryoException(e);
            }
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                output.writeVarInt(0, true);
            } else if (bigDecimal == BigDecimal.ZERO) {
                this.bigIntegerSerializer.write2(kryo, output, BigInteger.ZERO);
                output.writeInt(0, false);
            } else {
                this.bigIntegerSerializer.write2(kryo, output, bigDecimal.unscaledValue());
                output.writeInt(bigDecimal.scale(), false);
            }
        }
    }

    public static class BigIntegerSerializer extends Serializer<BigInteger> {
        public BigIntegerSerializer() {
            setImmutable(true);
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ BigInteger read(Kryo kryo, Input input, Class<BigInteger> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, BigInteger bigInteger) {
            write2(kryo, output, bigInteger);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public BigInteger read2(Kryo kryo, Input input, Class<BigInteger> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            byte[] bytes = input.readBytes(varInt - 1);
            if (cls != BigInteger.class && cls != null) {
                try {
                    Constructor<BigInteger> constructor = cls.getConstructor(byte[].class);
                    if (!constructor.isAccessible()) {
                        try {
                            constructor.setAccessible(true);
                        } catch (SecurityException unused) {
                        }
                    }
                    return constructor.newInstance(bytes);
                } catch (Exception e) {
                    throw new KryoException(e);
                }
            }
            if (varInt == 2) {
                byte b2 = bytes[0];
                if (b2 == 0) {
                    return BigInteger.ZERO;
                }
                if (b2 == 1) {
                    return BigInteger.ONE;
                }
                if (b2 == 10) {
                    return BigInteger.TEN;
                }
            }
            return new BigInteger(bytes);
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, BigInteger bigInteger) {
            if (bigInteger == null) {
                output.writeVarInt(0, true);
                return;
            }
            if (bigInteger == BigInteger.ZERO) {
                output.writeVarInt(2, true);
                output.writeByte(0);
            } else {
                byte[] byteArray = bigInteger.toByteArray();
                output.writeVarInt(byteArray.length + 1, true);
                output.writeBytes(byteArray);
            }
        }
    }

    public static class BooleanSerializer extends Serializer<Boolean> {
        public BooleanSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Boolean read(Kryo kryo, Input input, Class<Boolean> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Boolean bool) {
            write2(kryo, output, bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Boolean read(Kryo kryo, Input input, Class<Boolean> cls) {
            return Boolean.valueOf(input.readBoolean());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Boolean bool) {
            output.writeBoolean(bool.booleanValue());
        }
    }

    public static class ByteSerializer extends Serializer<Byte> {
        public ByteSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Byte read(Kryo kryo, Input input, Class<Byte> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Byte b2) {
            write2(kryo, output, b2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Byte read(Kryo kryo, Input input, Class<Byte> cls) {
            return Byte.valueOf(input.readByte());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Byte b2) {
            output.writeByte(b2.byteValue());
        }
    }

    public static class CalendarSerializer extends Serializer<Calendar> {
        private static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
        public TimeZoneSerializer timeZoneSerializer = new TimeZoneSerializer();

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Calendar copy(Kryo kryo, Calendar calendar) {
            return copy2(kryo, calendar);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Calendar read(Kryo kryo, Input input, Class<Calendar> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Calendar calendar) {
            write2(kryo, output, calendar);
        }

        /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
        public Calendar copy2(Kryo kryo, Calendar calendar) {
            return (Calendar) calendar.clone();
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Calendar read2(Kryo kryo, Input input, Class<Calendar> cls) {
            Calendar calendar = Calendar.getInstance(this.timeZoneSerializer.read2(kryo, input, TimeZone.class));
            calendar.setTimeInMillis(input.readLong(true));
            calendar.setLenient(input.readBoolean());
            calendar.setFirstDayOfWeek(input.readInt(true));
            calendar.setMinimalDaysInFirstWeek(input.readInt(true));
            long j = input.readLong(false);
            if (j != DEFAULT_GREGORIAN_CUTOVER && (calendar instanceof GregorianCalendar)) {
                ((GregorianCalendar) calendar).setGregorianChange(new Date(j));
            }
            return calendar;
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Calendar calendar) {
            this.timeZoneSerializer.write2(kryo, output, calendar.getTimeZone());
            output.writeLong(calendar.getTimeInMillis(), true);
            output.writeBoolean(calendar.isLenient());
            output.writeInt(calendar.getFirstDayOfWeek(), true);
            output.writeInt(calendar.getMinimalDaysInFirstWeek(), true);
            if (calendar instanceof GregorianCalendar) {
                output.writeLong(((GregorianCalendar) calendar).getGregorianChange().getTime(), false);
            } else {
                output.writeLong(DEFAULT_GREGORIAN_CUTOVER, false);
            }
        }
    }

    public static class CharSerializer extends Serializer<Character> {
        public CharSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Character read(Kryo kryo, Input input, Class<Character> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Character ch) {
            write2(kryo, output, ch);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Character read(Kryo kryo, Input input, Class<Character> cls) {
            return Character.valueOf(input.readChar());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Character ch) {
            output.writeChar(ch.charValue());
        }
    }

    public static class CharsetSerializer extends Serializer<Charset> {
        public CharsetSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Charset read(Kryo kryo, Input input, Class<Charset> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Charset charset) {
            write2(kryo, output, charset);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Charset read2(Kryo kryo, Input input, Class<Charset> cls) {
            return Charset.forName(input.readString());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Charset charset) {
            output.writeString(charset.name());
        }
    }

    public static class ClassSerializer extends Serializer<Class> {
        public ClassSerializer() {
            setImmutable(true);
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Class read(Kryo kryo, Input input, Class<Class> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Class cls) {
            write2(kryo, output, cls);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Class read(Kryo kryo, Input input, Class<Class> cls) {
            Registration registration = kryo.readClass(input);
            int i = input.read();
            Class type = registration != null ? registration.getType() : null;
            return (type == null || !type.isPrimitive() || i == 1) ? type : Util.getWrapperClass(type);
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Class cls) {
            kryo.writeClass(output, cls);
            output.writeByte((cls == null || !cls.isPrimitive()) ? 0 : 1);
        }
    }

    public static class CollectionsEmptyListSerializer extends Serializer {
        public CollectionsEmptyListSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public Object read(Kryo kryo, Input input, Class cls) {
            return Collections.EMPTY_LIST;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, Object obj) {
        }
    }

    public static class CollectionsEmptyMapSerializer extends Serializer {
        public CollectionsEmptyMapSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public Object read(Kryo kryo, Input input, Class cls) {
            return Collections.EMPTY_MAP;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, Object obj) {
        }
    }

    public static class CollectionsEmptySetSerializer extends Serializer {
        public CollectionsEmptySetSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public Object read(Kryo kryo, Input input, Class cls) {
            return Collections.EMPTY_SET;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, Object obj) {
        }
    }

    public static class CollectionsSingletonListSerializer extends Serializer<List> {
        public CollectionsSingletonListSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ List read(Kryo kryo, Input input, Class<List> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, List list) {
            write2(kryo, output, list);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public List read2(Kryo kryo, Input input, Class<List> cls) {
            return Collections.singletonList(kryo.readClassAndObject(input));
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, List list) {
            kryo.writeClassAndObject(output, list.get(0));
        }
    }

    public static class CollectionsSingletonMapSerializer extends Serializer<Map> {
        public CollectionsSingletonMapSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Map read(Kryo kryo, Input input, Class<Map> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Map map) {
            write2(kryo, output, map);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Map read2(Kryo kryo, Input input, Class<Map> cls) {
            return Collections.singletonMap(kryo.readClassAndObject(input), kryo.readClassAndObject(input));
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Map map) {
            Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
            kryo.writeClassAndObject(output, entry.getKey());
            kryo.writeClassAndObject(output, entry.getValue());
        }
    }

    public static class CollectionsSingletonSetSerializer extends Serializer<Set> {
        public CollectionsSingletonSetSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Set read(Kryo kryo, Input input, Class<Set> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Set set) {
            write2(kryo, output, set);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Set read2(Kryo kryo, Input input, Class<Set> cls) {
            return Collections.singleton(kryo.readClassAndObject(input));
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Set set) {
            kryo.writeClassAndObject(output, set.iterator().next());
        }
    }

    public static class CurrencySerializer extends Serializer<Currency> {
        public CurrencySerializer() {
            setImmutable(true);
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Currency read(Kryo kryo, Input input, Class<Currency> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Currency currency) {
            write2(kryo, output, currency);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Currency read2(Kryo kryo, Input input, Class<Currency> cls) {
            String string = input.readString();
            if (string == null) {
                return null;
            }
            return Currency.getInstance(string);
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Currency currency) {
            output.writeString(currency == null ? null : currency.getCurrencyCode());
        }
    }

    public static class DateSerializer extends Serializer<Date> {
        private Date create(Kryo kryo, Class<? extends Date> cls, long j) throws KryoException {
            if (cls == Date.class || cls == null) {
                return new Date(j);
            }
            if (cls == Timestamp.class) {
                return new Timestamp(j);
            }
            if (cls == java.sql.Date.class) {
                return new java.sql.Date(j);
            }
            if (cls == Time.class) {
                return new Time(j);
            }
            try {
                Constructor<? extends Date> constructor = cls.getConstructor(Long.TYPE);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    } catch (SecurityException unused) {
                    }
                }
                return constructor.newInstance(Long.valueOf(j));
            } catch (Exception unused2) {
                Date date = (Date) kryo.newInstance(cls);
                date.setTime(j);
                return date;
            }
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Date copy(Kryo kryo, Date date) {
            return copy2(kryo, date);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Date read(Kryo kryo, Input input, Class<Date> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Date date) {
            write2(kryo, output, date);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
        public Date copy2(Kryo kryo, Date date) {
            return create(kryo, date.getClass(), date.getTime());
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Date read2(Kryo kryo, Input input, Class<Date> cls) {
            return create(kryo, cls, input.readLong(true));
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Date date) {
            output.writeLong(date.getTime(), true);
        }
    }

    public static class DoubleSerializer extends Serializer<Double> {
        public DoubleSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Double read(Kryo kryo, Input input, Class<Double> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Double d) {
            write2(kryo, output, d);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Double read(Kryo kryo, Input input, Class<Double> cls) {
            return Double.valueOf(input.readDouble());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Double d) {
            output.writeDouble(d.doubleValue());
        }
    }

    public static class EnumSerializer extends Serializer<Enum> {
        private Object[] enumConstants;

        public EnumSerializer(Class<? extends Enum> cls) {
            setImmutable(true);
            setAcceptsNull(true);
            Object[] enumConstants = cls.getEnumConstants();
            this.enumConstants = enumConstants;
            if (enumConstants != null || Enum.class.equals(cls)) {
                return;
            }
            throw new IllegalArgumentException("The type must be an enum: " + cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Enum read(Kryo kryo, Input input, Class<Enum> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Enum r3) {
            write2(kryo, output, r3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Enum read(Kryo kryo, Input input, Class<Enum> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            int i = varInt - 1;
            if (i >= 0) {
                Object[] objArr = this.enumConstants;
                if (i <= objArr.length - 1) {
                    return (Enum) objArr[i];
                }
            }
            StringBuilder sbM833U = outline.m833U("Invalid ordinal for enum \"");
            sbM833U.append(cls.getName());
            sbM833U.append("\": ");
            sbM833U.append(i);
            throw new KryoException(sbM833U.toString());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Enum r3) {
            if (r3 == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(r3.ordinal() + 1, true);
            }
        }
    }

    public static class EnumSetSerializer extends Serializer<EnumSet> {
        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ EnumSet copy(Kryo kryo, EnumSet enumSet) {
            return copy2(kryo, enumSet);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ EnumSet read(Kryo kryo, Input input, Class<EnumSet> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, EnumSet enumSet) {
            write2(kryo, output, enumSet);
        }

        /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
        public EnumSet copy2(Kryo kryo, EnumSet enumSet) {
            return EnumSet.copyOf(enumSet);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public EnumSet read2(Kryo kryo, Input input, Class<EnumSet> cls) {
            Registration registration = kryo.readClass(input);
            EnumSet enumSetNoneOf = EnumSet.noneOf(registration.getType());
            Serializer serializer = registration.getSerializer();
            int i = input.readInt(true);
            for (int i2 = 0; i2 < i; i2++) {
                enumSetNoneOf.add(serializer.read(kryo, input, null));
            }
            return enumSetNoneOf;
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, EnumSet enumSet) {
            Serializer serializer;
            if (enumSet.isEmpty()) {
                EnumSet enumSetComplementOf = EnumSet.complementOf(enumSet);
                if (enumSetComplementOf.isEmpty()) {
                    throw new KryoException("An EnumSet must have a defined Enum to be serialized.");
                }
                serializer = kryo.writeClass(output, enumSetComplementOf.iterator().next().getClass()).getSerializer();
            } else {
                serializer = kryo.writeClass(output, enumSet.iterator().next().getClass()).getSerializer();
            }
            output.writeInt(enumSet.size(), true);
            Iterator it = enumSet.iterator();
            while (it.hasNext()) {
                serializer.write(kryo, output, it.next());
            }
        }
    }

    public static class FloatSerializer extends Serializer<Float> {
        public FloatSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Float read(Kryo kryo, Input input, Class<Float> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Float f) {
            write2(kryo, output, f);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Float read(Kryo kryo, Input input, Class<Float> cls) {
            return Float.valueOf(input.readFloat());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Float f) {
            output.writeFloat(f.floatValue());
        }
    }

    public static class IntSerializer extends Serializer<Integer> {
        public IntSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Integer read(Kryo kryo, Input input, Class<Integer> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Integer num) {
            write2(kryo, output, num);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Integer read(Kryo kryo, Input input, Class<Integer> cls) {
            return Integer.valueOf(input.readInt(false));
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Integer num) {
            output.writeInt(num.intValue(), false);
        }
    }

    public static class KryoSerializableSerializer extends Serializer<KryoSerializable> {
        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ KryoSerializable read(Kryo kryo, Input input, Class<KryoSerializable> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, KryoSerializable kryoSerializable) {
            write2(kryo, output, kryoSerializable);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public KryoSerializable read(Kryo kryo, Input input, Class<KryoSerializable> cls) {
            KryoSerializable kryoSerializable = (KryoSerializable) kryo.newInstance(cls);
            kryo.reference(kryoSerializable);
            kryoSerializable.read(kryo, input);
            return kryoSerializable;
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, KryoSerializable kryoSerializable) {
            kryoSerializable.write(kryo, output);
        }
    }

    public static class LocaleSerializer extends Serializer<Locale> {
        public static final Locale SPANISH = new Locale("es", "", "");
        public static final Locale SPAIN = new Locale("es", "ES", "");

        public LocaleSerializer() {
            setImmutable(true);
        }

        public static boolean isSameLocale(Locale locale, String str, String str2, String str3) {
            try {
                if (locale.getLanguage().equals(str) && locale.getCountry().equals(str2)) {
                    return locale.getVariant().equals(str3);
                }
                return false;
            } catch (NullPointerException unused) {
                return false;
            }
        }

        public Locale create(String str, String str2, String str3) {
            Locale locale = Locale.getDefault();
            if (isSameLocale(locale, str, str2, str3)) {
                return locale;
            }
            Locale locale2 = Locale.US;
            if (locale != locale2 && isSameLocale(locale2, str, str2, str3)) {
                return locale2;
            }
            Locale locale3 = Locale.ENGLISH;
            if (isSameLocale(locale3, str, str2, str3)) {
                return locale3;
            }
            if (isSameLocale(Locale.GERMAN, str, str2, str3)) {
                return Locale.GERMAN;
            }
            Locale locale4 = SPANISH;
            if (isSameLocale(locale4, str, str2, str3)) {
                return locale4;
            }
            if (isSameLocale(Locale.FRENCH, str, str2, str3)) {
                return Locale.FRENCH;
            }
            if (isSameLocale(Locale.ITALIAN, str, str2, str3)) {
                return Locale.ITALIAN;
            }
            if (isSameLocale(Locale.JAPANESE, str, str2, str3)) {
                return Locale.JAPANESE;
            }
            if (isSameLocale(Locale.KOREAN, str, str2, str3)) {
                return Locale.KOREAN;
            }
            if (isSameLocale(Locale.SIMPLIFIED_CHINESE, str, str2, str3)) {
                return Locale.SIMPLIFIED_CHINESE;
            }
            if (isSameLocale(Locale.CHINESE, str, str2, str3)) {
                return Locale.CHINESE;
            }
            if (isSameLocale(Locale.TRADITIONAL_CHINESE, str, str2, str3)) {
                return Locale.TRADITIONAL_CHINESE;
            }
            if (isSameLocale(Locale.UK, str, str2, str3)) {
                return Locale.UK;
            }
            if (isSameLocale(Locale.GERMANY, str, str2, str3)) {
                return Locale.GERMANY;
            }
            Locale locale5 = SPAIN;
            return isSameLocale(locale5, str, str2, str3) ? locale5 : isSameLocale(Locale.FRANCE, str, str2, str3) ? Locale.FRANCE : isSameLocale(Locale.ITALY, str, str2, str3) ? Locale.ITALY : isSameLocale(Locale.JAPAN, str, str2, str3) ? Locale.JAPAN : isSameLocale(Locale.KOREA, str, str2, str3) ? Locale.KOREA : isSameLocale(Locale.CANADA, str, str2, str3) ? Locale.CANADA : isSameLocale(Locale.CANADA_FRENCH, str, str2, str3) ? Locale.CANADA_FRENCH : new Locale(str, str2, str3);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Locale read(Kryo kryo, Input input, Class<Locale> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Locale locale) {
            write2(kryo, output, locale);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Locale read2(Kryo kryo, Input input, Class<Locale> cls) {
            return create(input.readString(), input.readString(), input.readString());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Locale locale) {
            output.writeAscii(locale.getLanguage());
            output.writeAscii(locale.getCountry());
            output.writeString(locale.getVariant());
        }
    }

    public static class LongSerializer extends Serializer<Long> {
        public LongSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Long read(Kryo kryo, Input input, Class<Long> cls) {
            return read(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Long l) {
            write2(kryo, output, l);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.esotericsoftware.kryo.Serializer
        public Long read(Kryo kryo, Input input, Class<Long> cls) {
            return Long.valueOf(input.readLong(false));
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Long l) {
            output.writeLong(l.longValue(), false);
        }
    }

    public static class ShortSerializer extends Serializer<Short> {
        public ShortSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Short read(Kryo kryo, Input input, Class<Short> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Short sh) {
            write2(kryo, output, sh);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Short read2(Kryo kryo, Input input, Class<Short> cls) {
            return Short.valueOf(input.readShort());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Short sh) {
            output.writeShort(sh.shortValue());
        }
    }

    public static class StringBufferSerializer extends Serializer<StringBuffer> {
        public StringBufferSerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ StringBuffer copy(Kryo kryo, StringBuffer stringBuffer) {
            return copy2(kryo, stringBuffer);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ StringBuffer read(Kryo kryo, Input input, Class<StringBuffer> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, StringBuffer stringBuffer) {
            write2(kryo, output, stringBuffer);
        }

        /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
        public StringBuffer copy2(Kryo kryo, StringBuffer stringBuffer) {
            return new StringBuffer(stringBuffer);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public StringBuffer read2(Kryo kryo, Input input, Class<StringBuffer> cls) {
            String string = input.readString();
            if (string == null) {
                return null;
            }
            return new StringBuffer(string);
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, StringBuffer stringBuffer) {
            output.writeString(stringBuffer);
        }
    }

    public static class StringBuilderSerializer extends Serializer<StringBuilder> {
        public StringBuilderSerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ StringBuilder copy(Kryo kryo, StringBuilder sb) {
            return copy2(kryo, sb);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ StringBuilder read(Kryo kryo, Input input, Class<StringBuilder> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, StringBuilder sb) {
            write2(kryo, output, sb);
        }

        /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
        public StringBuilder copy2(Kryo kryo, StringBuilder sb) {
            return new StringBuilder(sb);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public StringBuilder read2(Kryo kryo, Input input, Class<StringBuilder> cls) {
            return input.readStringBuilder();
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, StringBuilder sb) {
            output.writeString(sb);
        }
    }

    public static class StringSerializer extends Serializer<String> {
        public StringSerializer() {
            setImmutable(true);
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ String read(Kryo kryo, Input input, Class<String> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, String str) {
            write2(kryo, output, str);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public String read2(Kryo kryo, Input input, Class<String> cls) {
            return input.readString();
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, String str) {
            output.writeString(str);
        }
    }

    public static class TimeZoneSerializer extends Serializer<TimeZone> {
        public TimeZoneSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ TimeZone read(Kryo kryo, Input input, Class<TimeZone> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, TimeZone timeZone) {
            write2(kryo, output, timeZone);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public TimeZone read2(Kryo kryo, Input input, Class<TimeZone> cls) {
            return TimeZone.getTimeZone(input.readString());
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, TimeZone timeZone) {
            output.writeString(timeZone.getID());
        }
    }

    public static class TreeMapSerializer extends MapSerializer {
        private TreeMap createTreeMap(Class<? extends Map> cls, Comparator comparator) {
            if (cls == TreeMap.class || cls == null) {
                return new TreeMap(comparator);
            }
            try {
                Constructor<? extends Map> constructor = cls.getConstructor(Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    } catch (SecurityException unused) {
                    }
                }
                return (TreeMap) constructor.newInstance(comparator);
            } catch (Exception e) {
                throw new KryoException(e);
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.MapSerializer
        public Map create(Kryo kryo, Input input, Class<Map> cls) {
            return createTreeMap(cls, (Comparator) kryo.readClassAndObject(input));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.esotericsoftware.kryo.serializers.MapSerializer
        public Map createCopy(Kryo kryo, Map map) {
            return createTreeMap(map.getClass(), ((TreeMap) map).comparator());
        }

        @Override // com.esotericsoftware.kryo.serializers.MapSerializer, com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Map map) {
            write2(kryo, output, map);
        }

        @Override // com.esotericsoftware.kryo.serializers.MapSerializer
        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Map map) {
            kryo.writeClassAndObject(output, ((TreeMap) map).comparator());
            super.write(kryo, output, map);
        }
    }

    public static class TreeSetSerializer extends CollectionSerializer {
        private TreeSet createTreeSet(Class<? extends Collection> cls, Comparator comparator) {
            if (cls == TreeSet.class || cls == null) {
                return new TreeSet(comparator);
            }
            try {
                Constructor<? extends Collection> constructor = cls.getConstructor(Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    } catch (SecurityException unused) {
                    }
                }
                return (TreeSet) constructor.newInstance(comparator);
            } catch (Exception e) {
                throw new KryoException(e);
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
        public /* bridge */ /* synthetic */ Collection create(Kryo kryo, Input input, Class cls) {
            return create(kryo, input, (Class<Collection>) cls);
        }

        @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
        public /* bridge */ /* synthetic */ Collection createCopy(Kryo kryo, Collection collection) {
            return createCopy(kryo, collection);
        }

        @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer, com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Collection collection) {
            write2(kryo, output, collection);
        }

        @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
        public TreeSet create(Kryo kryo, Input input, Class<Collection> cls) {
            return createTreeSet(cls, (Comparator) kryo.readClassAndObject(input));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
        public TreeSet createCopy(Kryo kryo, Collection collection) {
            return createTreeSet(collection.getClass(), ((TreeSet) collection).comparator());
        }

        @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Collection collection) {
            kryo.writeClassAndObject(output, ((TreeSet) collection).comparator());
            super.write2(kryo, output, collection);
        }
    }

    public static class URLSerializer extends Serializer<URL> {
        public URLSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ URL read(Kryo kryo, Input input, Class<URL> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, URL url) {
            write2(kryo, output, url);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public URL read2(Kryo kryo, Input input, Class<URL> cls) {
            try {
                return new URL(input.readString());
            } catch (MalformedURLException e) {
                throw new KryoException(e);
            }
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, URL url) {
            output.writeString(url.toExternalForm());
        }
    }

    public static class VoidSerializer extends Serializer {
        public VoidSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public Object read(Kryo kryo, Input input, Class cls) {
            return null;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, Object obj) {
        }
    }
}

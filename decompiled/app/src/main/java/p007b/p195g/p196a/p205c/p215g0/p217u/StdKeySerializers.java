package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.EnumValues;

/* JADX INFO: renamed from: b.g.a.c.g0.u.o0, reason: use source file name */
/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StdKeySerializers {

    /* JADX INFO: renamed from: a */
    public static final JsonSerializer<Object> f4858a = new d();

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$a */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class a extends StdSerializer<Object> {
        public final int _typeId;

        public a(int i, Class<?> cls) {
            super(cls, false);
            this._typeId = i;
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String strValueOf;
            switch (this._typeId) {
                case 1:
                    Date date = (Date) obj;
                    Objects.requireNonNull(serializerProvider);
                    if (!serializerProvider.m2240D(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        jsonGenerator.mo1666y(serializerProvider.m2246j().format(date));
                    } else {
                        jsonGenerator.mo1666y(String.valueOf(date.getTime()));
                    }
                    break;
                case 2:
                    long timeInMillis = ((Calendar) obj).getTimeInMillis();
                    Objects.requireNonNull(serializerProvider);
                    if (!serializerProvider.m2240D(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        jsonGenerator.mo1666y(serializerProvider.m2246j().format(new Date(timeInMillis)));
                    } else {
                        jsonGenerator.mo1666y(String.valueOf(timeInMillis));
                    }
                    break;
                case 3:
                    jsonGenerator.mo1666y(((Class) obj).getName());
                    break;
                case 4:
                    if (serializerProvider.m2240D(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                        strValueOf = obj.toString();
                    } else {
                        Enum r3 = (Enum) obj;
                        strValueOf = serializerProvider.m2240D(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r3.ordinal()) : r3.name();
                    }
                    jsonGenerator.mo1666y(strValueOf);
                    break;
                case 5:
                case 6:
                    long jLongValue = ((Number) obj).longValue();
                    Objects.requireNonNull(jsonGenerator);
                    jsonGenerator.mo1666y(Long.toString(jLongValue));
                    break;
                case 7:
                    jsonGenerator.mo1666y(serializerProvider._config._base._defaultBase64.m1622a((byte[]) obj));
                    break;
                default:
                    jsonGenerator.mo1666y(obj.toString());
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$b */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class b extends StdSerializer<Object> {

        /* JADX INFO: renamed from: k */
        public transient PropertySerializerMap f4859k;

        public b() {
            super(String.class, false);
            this.f4859k = PropertySerializerMap.b.f4828b;
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            Class<?> cls = obj.getClass();
            PropertySerializerMap propertySerializerMap = this.f4859k;
            JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
            if (jsonSerializerMo2034c == null) {
                if (cls == Object.class) {
                    jsonSerializerMo2034c = new a(8, cls);
                    this.f4859k = propertySerializerMap.mo2033b(cls, jsonSerializerMo2034c);
                } else {
                    jsonSerializerMo2034c = serializerProvider.m2251o(serializerProvider._config._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l), null);
                    PropertySerializerMap propertySerializerMapMo2033b = propertySerializerMap.mo2033b(cls, jsonSerializerMo2034c);
                    if (propertySerializerMap != propertySerializerMapMo2033b) {
                        this.f4859k = propertySerializerMapMo2033b;
                    }
                }
            }
            jsonSerializerMo2034c.mo1807f(obj, jsonGenerator, serializerProvider);
        }

        public Object readResolve() {
            this.f4859k = PropertySerializerMap.b.f4828b;
            return this;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$c */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class c extends StdSerializer<Object> {
        public final EnumValues _values;

        public c(Class<?> cls, EnumValues enumValues) {
            super(cls, false);
            this._values = enumValues;
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (serializerProvider.m2240D(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                jsonGenerator.mo1666y(obj.toString());
                return;
            }
            Enum<?> r2 = (Enum) obj;
            if (serializerProvider.m2240D(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX)) {
                jsonGenerator.mo1666y(String.valueOf(r2.ordinal()));
            } else {
                jsonGenerator.mo1665x(this._values.m2200c(r2));
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$d */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class d extends StdSerializer<Object> {
        public d() {
            super(String.class, false);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.mo1666y((String) obj);
        }
    }
}

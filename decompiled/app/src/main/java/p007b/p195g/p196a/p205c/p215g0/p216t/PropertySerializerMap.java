package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Arrays;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;

/* JADX INFO: renamed from: b.g.a.c.g0.t.l, reason: use source file name */
/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertySerializerMap {

    /* JADX INFO: renamed from: a */
    public final boolean f4823a;

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$a */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class a extends PropertySerializerMap {

        /* JADX INFO: renamed from: b */
        public final Class<?> f4824b;

        /* JADX INFO: renamed from: c */
        public final Class<?> f4825c;

        /* JADX INFO: renamed from: d */
        public final JsonSerializer<Object> f4826d;

        /* JADX INFO: renamed from: e */
        public final JsonSerializer<Object> f4827e;

        public a(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer, Class<?> cls2, JsonSerializer<Object> jsonSerializer2) {
            super(propertySerializerMap);
            this.f4824b = cls;
            this.f4826d = jsonSerializer;
            this.f4825c = cls2;
            this.f4827e = jsonSerializer2;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: b */
        public PropertySerializerMap mo2033b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new c(this, new f[]{new f(this.f4824b, this.f4826d), new f(this.f4825c, this.f4827e), new f(cls, jsonSerializer)});
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: c */
        public JsonSerializer<Object> mo2034c(Class<?> cls) {
            if (cls == this.f4824b) {
                return this.f4826d;
            }
            if (cls == this.f4825c) {
                return this.f4827e;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$b */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class b extends PropertySerializerMap {

        /* JADX INFO: renamed from: b */
        public static final b f4828b = new b(false);

        public b(boolean z2) {
            super(z2);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: b */
        public PropertySerializerMap mo2033b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new e(this, cls, jsonSerializer);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: c */
        public JsonSerializer<Object> mo2034c(Class<?> cls) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$c */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class c extends PropertySerializerMap {

        /* JADX INFO: renamed from: b */
        public final f[] f4829b;

        public c(PropertySerializerMap propertySerializerMap, f[] fVarArr) {
            super(propertySerializerMap);
            this.f4829b = fVarArr;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: b */
        public PropertySerializerMap mo2033b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            f[] fVarArr = this.f4829b;
            int length = fVarArr.length;
            if (length == 8) {
                return this.f4823a ? new e(this, cls, jsonSerializer) : this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, jsonSerializer);
            return new c(this, fVarArr2);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: c */
        public JsonSerializer<Object> mo2034c(Class<?> cls) {
            f[] fVarArr = this.f4829b;
            f fVar = fVarArr[0];
            if (fVar.f4834a == cls) {
                return fVar.f4835b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.f4834a == cls) {
                return fVar2.f4835b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.f4834a == cls) {
                return fVar3.f4835b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.f4834a == cls) {
                        return fVar4.f4835b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.f4834a == cls) {
                        return fVar5.f4835b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.f4834a == cls) {
                        return fVar6.f4835b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.f4834a == cls) {
                        return fVar7.f4835b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.f4834a == cls) {
                        return fVar8.f4835b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$d */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final JsonSerializer<Object> f4830a;

        /* JADX INFO: renamed from: b */
        public final PropertySerializerMap f4831b;

        public d(JsonSerializer<Object> jsonSerializer, PropertySerializerMap propertySerializerMap) {
            this.f4830a = jsonSerializer;
            this.f4831b = propertySerializerMap;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$e */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class e extends PropertySerializerMap {

        /* JADX INFO: renamed from: b */
        public final Class<?> f4832b;

        /* JADX INFO: renamed from: c */
        public final JsonSerializer<Object> f4833c;

        public e(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            super(propertySerializerMap);
            this.f4832b = cls;
            this.f4833c = jsonSerializer;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: b */
        public PropertySerializerMap mo2033b(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new a(this, this.f4832b, this.f4833c, cls, jsonSerializer);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap
        /* JADX INFO: renamed from: c */
        public JsonSerializer<Object> mo2034c(Class<?> cls) {
            if (cls == this.f4832b) {
                return this.f4833c;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$f */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class f {

        /* JADX INFO: renamed from: a */
        public final Class<?> f4834a;

        /* JADX INFO: renamed from: b */
        public final JsonSerializer<Object> f4835b;

        public f(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            this.f4834a = cls;
            this.f4835b = jsonSerializer;
        }
    }

    public PropertySerializerMap(boolean z2) {
        this.f4823a = z2;
    }

    /* JADX INFO: renamed from: a */
    public final d m2032a(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2249m = serializerProvider.m2249m(javaType, beanProperty);
        return new d(jsonSerializerM2249m, mo2033b(javaType._class, jsonSerializerM2249m));
    }

    /* JADX INFO: renamed from: b */
    public abstract PropertySerializerMap mo2033b(Class<?> cls, JsonSerializer<Object> jsonSerializer);

    /* JADX INFO: renamed from: c */
    public abstract JsonSerializer<Object> mo2034c(Class<?> cls);

    public PropertySerializerMap(PropertySerializerMap propertySerializerMap) {
        this.f4823a = propertySerializerMap.f4823a;
    }
}

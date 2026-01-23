package p007b.p195g.p196a.p205c.p219i0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p200p.SerializedString;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.i0.f, reason: use source file name */
/* JADX INFO: compiled from: EnumValues.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumValues implements Serializable {
    private static final long serialVersionUID = 1;
    private final Class<Enum<?>> _enumClass;
    private final SerializableString[] _textual;
    private final Enum<?>[] _values;

    public EnumValues(Class<Enum<?>> cls, SerializableString[] serializableStringArr) {
        this._enumClass = cls;
        this._values = cls.getEnumConstants();
        this._textual = serializableStringArr;
    }

    /* JADX INFO: renamed from: a */
    public static EnumValues m2198a(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Annotation[] annotationArr = ClassUtil.f4944a;
        Class<Enum<?>> superclass = cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
        Enum<?>[] enumConstants = superclass.getEnumConstants();
        if (enumConstants == null) {
            StringBuilder sbM833U = outline.m833U("Cannot determine enum constants for Class ");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
        String[] strArrMo1781f = mapperConfig.m2267e().mo1781f(superclass, enumConstants, new String[enumConstants.length]);
        SerializableString[] serializableStringArr = new SerializableString[enumConstants.length];
        int length = enumConstants.length;
        for (int i = 0; i < length; i++) {
            Enum<?> r4 = enumConstants[i];
            String strName = strArrMo1781f[i];
            if (strName == null) {
                strName = r4.name();
            }
            serializableStringArr[r4.ordinal()] = new SerializedString(strName);
        }
        return new EnumValues(cls, serializableStringArr);
    }

    /* JADX INFO: renamed from: b */
    public Class<Enum<?>> m2199b() {
        return this._enumClass;
    }

    /* JADX INFO: renamed from: c */
    public SerializableString m2200c(Enum<?> r2) {
        return this._textual[r2.ordinal()];
    }
}

package p007b.p195g.p196a.p205c.p218h0;

import com.discord.widgets.chat.input.MentionUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializable;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.h0.l, reason: use source file name */
/* JADX INFO: compiled from: TypeBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeBase extends JavaType implements JsonSerializable {

    /* JADX INFO: renamed from: j */
    public static final TypeBindings f4905j = TypeBindings.f4908l;
    private static final long serialVersionUID = 1;
    public final TypeBindings _bindings;
    public final JavaType _superClass;
    public final JavaType[] _superInterfaces;

    public TypeBase(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, i, obj, obj2, z2);
        this._bindings = typeBindings == null ? f4905j : typeBindings;
        this._superClass = javaType;
        this._superInterfaces = javaTypeArr;
    }

    /* JADX INFO: renamed from: J */
    public static StringBuilder m2139J(Class<?> cls, StringBuilder sb, boolean z2) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt == '.') {
                    cCharAt = MentionUtils.SLASH_CHAR;
                }
                sb.append(cCharAt);
            }
            if (z2) {
                sb.append(';');
            }
        } else if (cls == Boolean.TYPE) {
            sb.append('Z');
        } else if (cls == Byte.TYPE) {
            sb.append('B');
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append('I');
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append('D');
        } else {
            if (cls != Void.TYPE) {
                StringBuilder sbM833U = outline.m833U("Unrecognized primitive type: ");
                sbM833U.append(cls.getName());
                throw new IllegalStateException(sbM833U.toString());
            }
            sb.append('V');
        }
        return sb;
    }

    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        return this._class.getName();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializable
    /* JADX INFO: renamed from: c */
    public void mo2140c(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1658j0(mo2106K());
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializable
    /* JADX INFO: renamed from: d */
    public void mo2141d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeId = new WritableTypeId(this, JsonToken2.VALUE_STRING);
        typeSerializer.mo1959e(jsonGenerator, writableTypeId);
        jsonGenerator.mo1658j0(mo2106K());
        typeSerializer.mo1960f(jsonGenerator, writableTypeId);
    }

    @Override // p007b.p195g.p196a.p198b.p203s.ResolvedType
    /* JADX INFO: renamed from: e */
    public String mo1729e() {
        return mo2106K();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: f */
    public JavaType mo2142f(int i) {
        return this._bindings.m2151f(i);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: g */
    public int mo2143g() {
        return this._bindings.m2155j();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: i */
    public final JavaType mo2144i(Class<?> cls) {
        JavaType javaTypeMo2144i;
        JavaType[] javaTypeArr;
        if (cls == this._class) {
            return this;
        }
        if (cls.isInterface() && (javaTypeArr = this._superInterfaces) != null) {
            int length = javaTypeArr.length;
            for (int i = 0; i < length; i++) {
                JavaType javaTypeMo2144i2 = this._superInterfaces[i].mo2144i(cls);
                if (javaTypeMo2144i2 != null) {
                    return javaTypeMo2144i2;
                }
            }
        }
        JavaType javaType = this._superClass;
        if (javaType == null || (javaTypeMo2144i = javaType.mo2144i(cls)) == null) {
            return null;
        }
        return javaTypeMo2144i;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: j */
    public TypeBindings mo2136j() {
        return this._bindings;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: n */
    public List<JavaType> mo2145n() {
        JavaType[] javaTypeArr = this._superInterfaces;
        if (javaTypeArr == null) {
            return Collections.emptyList();
        }
        int length = javaTypeArr.length;
        return length != 0 ? length != 1 ? Arrays.asList(javaTypeArr) : Collections.singletonList(javaTypeArr[0]) : Collections.emptyList();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: q */
    public JavaType mo2137q() {
        return this._superClass;
    }
}

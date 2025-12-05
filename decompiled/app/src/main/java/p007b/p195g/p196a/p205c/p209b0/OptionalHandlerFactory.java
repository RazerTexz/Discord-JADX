package p007b.p195g.p196a.p205c.p209b0;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.p215g0.Serializers;
import p007b.p195g.p196a.p205c.p215g0.p217u.DateSerializer2;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: OptionalHandlerFactory.java */
/* renamed from: b.g.a.c.b0.f, reason: use source file name */
/* loaded from: classes3.dex */
public class OptionalHandlerFactory implements Serializable {

    /* renamed from: j */
    public static final Class<?> f4623j = Node.class;

    /* renamed from: k */
    public static final Java7Handlers f4624k;

    /* renamed from: l */
    public static final OptionalHandlerFactory f4625l;
    private static final long serialVersionUID = 1;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Java7Handlers java7Handlers = null;
        try {
            java7Handlers = Java7Handlers.f4620a;
        } catch (Throwable unused) {
        }
        f4624k = java7Handlers;
        f4625l = new OptionalHandlerFactory();
    }

    public OptionalHandlerFactory() {
        HashMap map = new HashMap();
        this._sqlDeserializers = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this._sqlSerializers = map2;
        map2.put("java.sql.Timestamp", DateSerializer2.f4856k);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    /* renamed from: a */
    public JsonSerializer<?> m1809a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JsonSerializer<?> jsonSerializerMo1803a;
        Class<?> superclass = javaType._class;
        Class<?> cls = f4623j;
        boolean z2 = true;
        if (cls != null && cls.isAssignableFrom(superclass)) {
            return (JsonSerializer) m1811c("com.fasterxml.jackson.databind.ext.DOMSerializer", javaType);
        }
        Java7Handlers java7Handlers = f4624k;
        if (java7Handlers != null && (jsonSerializerMo1803a = java7Handlers.mo1803a(superclass)) != null) {
            return jsonSerializerMo1803a;
        }
        String name = superclass.getName();
        Object obj = this._sqlSerializers.get(name);
        if (obj != null) {
            return obj instanceof JsonSerializer ? (JsonSerializer) obj : (JsonSerializer) m1811c((String) obj, javaType);
        }
        if (!name.startsWith("javax.xml.")) {
            do {
                superclass = superclass.getSuperclass();
                if (superclass == null || superclass == Object.class) {
                    z2 = false;
                    break;
                }
            } while (!superclass.getName().startsWith("javax.xml."));
            if (!z2) {
                return null;
            }
        }
        Object objM1811c = m1811c("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", javaType);
        if (objM1811c == null) {
            return null;
        }
        return ((Serializers) objM1811c).m2011b(serializationConfig, javaType, beanDescription);
    }

    /* renamed from: b */
    public final Object m1810b(Class<?> cls, JavaType javaType) {
        try {
            return ClassUtil.m2175g(cls, false);
        } catch (Throwable th) {
            StringBuilder sbM833U = outline.m833U("Failed to create instance of `");
            sbM833U.append(cls.getName());
            sbM833U.append("` for handling values of type ");
            sbM833U.append(ClassUtil.m2182n(javaType));
            sbM833U.append(", problem: (");
            sbM833U.append(th.getClass().getName());
            sbM833U.append(") ");
            sbM833U.append(th.getMessage());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* renamed from: c */
    public final Object m1811c(String str, JavaType javaType) {
        try {
            return m1810b(Class.forName(str), javaType);
        } catch (Throwable th) {
            StringBuilder sbM837Y = outline.m837Y("Failed to find class `", str, "` for handling values of type ");
            sbM837Y.append(ClassUtil.m2182n(javaType));
            sbM837Y.append(", problem: (");
            sbM837Y.append(th.getClass().getName());
            sbM837Y.append(") ");
            sbM837Y.append(th.getMessage());
            throw new IllegalStateException(sbM837Y.toString());
        }
    }
}

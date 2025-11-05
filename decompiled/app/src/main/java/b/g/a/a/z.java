package b.g.a.a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonSetter.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface z {

    /* compiled from: JsonSetter.java */
    public static class a implements Serializable {
        public static final a j;
        private static final long serialVersionUID = 1;
        private final h0 _contentNulls;
        private final h0 _nulls;

        static {
            h0 h0Var = h0.DEFAULT;
            j = new a(h0Var, h0Var);
        }

        public a(h0 h0Var, h0 h0Var2) {
            this._nulls = h0Var;
            this._contentNulls = h0Var2;
        }

        public h0 a() {
            h0 h0Var = this._contentNulls;
            if (h0Var == h0.DEFAULT) {
                return null;
            }
            return h0Var;
        }

        public h0 b() {
            h0 h0Var = this._nulls;
            if (h0Var == h0.DEFAULT) {
                return null;
            }
            return h0Var;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return aVar._nulls == this._nulls && aVar._contentNulls == this._contentNulls;
        }

        public int hashCode() {
            return this._nulls.ordinal() + (this._contentNulls.ordinal() << 2);
        }

        public Object readResolve() {
            h0 h0Var = this._nulls;
            h0 h0Var2 = this._contentNulls;
            h0 h0Var3 = h0.DEFAULT;
            return h0Var == h0Var3 && h0Var2 == h0Var3 ? j : this;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this._nulls, this._contentNulls);
        }
    }

    h0 contentNulls() default h0.DEFAULT;

    h0 nulls() default h0.DEFAULT;

    String value() default "";
}

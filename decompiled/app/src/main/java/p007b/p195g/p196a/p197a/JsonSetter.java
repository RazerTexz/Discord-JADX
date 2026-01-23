package p007b.p195g.p196a.p197a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.z, reason: use source file name */
/* JADX INFO: compiled from: JsonSetter.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSetter {

    /* JADX INFO: renamed from: b.g.a.a.z$a */
    /* JADX INFO: compiled from: JsonSetter.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f4443j;
        private static final long serialVersionUID = 1;
        private final Nulls _contentNulls;
        private final Nulls _nulls;

        static {
            Nulls nulls = Nulls.DEFAULT;
            f4443j = new a(nulls, nulls);
        }

        public a(Nulls nulls, Nulls nulls2) {
            this._nulls = nulls;
            this._contentNulls = nulls2;
        }

        /* JADX INFO: renamed from: a */
        public Nulls m1620a() {
            Nulls nulls = this._contentNulls;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        /* JADX INFO: renamed from: b */
        public Nulls m1621b() {
            Nulls nulls = this._nulls;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
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
            Nulls nulls = this._nulls;
            Nulls nulls2 = this._contentNulls;
            Nulls nulls3 = Nulls.DEFAULT;
            return nulls == nulls3 && nulls2 == nulls3 ? f4443j : this;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this._nulls, this._contentNulls);
        }
    }

    Nulls contentNulls() default Nulls.DEFAULT;

    Nulls nulls() default Nulls.DEFAULT;

    String value() default "";
}

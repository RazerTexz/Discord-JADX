package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Progressions2;
import p507d0.Tuples;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.ArrayIterator4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;
import p600f0.p601e0.Util7;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Headers implements Iterable<Tuples2<? extends String, ? extends String>>, KMarkers {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String[] namesAndValues;

    /* JADX INFO: renamed from: okhttp3.Headers$a */
    /* JADX INFO: compiled from: Headers.kt */
    public static final class C12930a {

        /* JADX INFO: renamed from: a */
        public final List<String> f27512a = new ArrayList(20);

        /* JADX INFO: renamed from: a */
        public final C12930a m10958a(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Companion companion = Headers.INSTANCE;
            companion.m10962a(str);
            companion.m10963b(str2, str);
            m10959b(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final C12930a m10959b(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            this.f27512a.add(str);
            this.f27512a.add(Strings4.trim(str2).toString());
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final Headers m10960c() {
            Object[] array = this.f27512a.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX INFO: renamed from: d */
        public final C12930a m10961d(String str) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            int i = 0;
            while (i < this.f27512a.size()) {
                if (StringsJVM.equals(str, this.f27512a.get(i), true)) {
                    this.f27512a.remove(i);
                    this.f27512a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Headers$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Headers.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m10962a(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util7.m10129j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m10963b(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(Util7.m10129j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public final Headers m10964c(String... strArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(strArr, "namesAndValues");
            if (!(strArr.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr2 = (String[]) objClone;
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                if (!(strArr2[i] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                String str = strArr2[i];
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr2[i] = Strings4.trim(str).toString();
            }
            Progressions2 progressions2Step = _Ranges.step(_Ranges.until(0, strArr2.length), 2);
            int first = progressions2Step.getFirst();
            int last = progressions2Step.getLast();
            int step = progressions2Step.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    String str2 = strArr2[first];
                    String str3 = strArr2[first + 1];
                    m10962a(str2);
                    m10963b(str3, str2);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            return new Headers(strArr2, null);
        }
    }

    public Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.namesAndValues = strArr;
    }

    /* JADX INFO: renamed from: c */
    public final String m10954c(String name) {
        Intrinsics3.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String[] strArr = this.namesAndValues;
        Progressions2 progressions2Step = _Ranges.step(_Ranges.downTo(strArr.length - 2, 0), 2);
        int first = progressions2Step.getFirst();
        int last = progressions2Step.getLast();
        int step = progressions2Step.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (!StringsJVM.equals(name, strArr[first], true)) {
                if (first != last) {
                    first += step;
                }
            }
            return strArr[first + 1];
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final String m10955d(int index) {
        return this.namesAndValues[index * 2];
    }

    /* JADX INFO: renamed from: e */
    public final C12930a m10956e() {
        C12930a c12930a = new C12930a();
        MutableCollections.addAll(c12930a.f27512a, this.namesAndValues);
        return c12930a;
    }

    public boolean equals(Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    /* JADX INFO: renamed from: g */
    public final String m10957g(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Tuples2<? extends String, ? extends String>> iterator() {
        int size = size();
        Tuples2[] tuples2Arr = new Tuples2[size];
        for (int i = 0; i < size; i++) {
            tuples2Arr[i] = Tuples.m10073to(m10955d(i), m10957g(i));
        }
        return ArrayIterator4.iterator(tuples2Arr);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(m10955d(i));
            sb.append(": ");
            sb.append(m10957g(i));
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

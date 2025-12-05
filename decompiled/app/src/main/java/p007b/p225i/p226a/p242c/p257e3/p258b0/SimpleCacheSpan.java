package p007b.p225i.p226a.p242c.p257e3.p258b0;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: SimpleCacheSpan.java */
/* renamed from: b.i.a.c.e3.b0.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class SimpleCacheSpan extends CacheSpan {

    /* renamed from: p */
    public static final Pattern f6517p = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: q */
    public static final Pattern f6518q = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: r */
    public static final Pattern f6519r = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public SimpleCacheSpan(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009f A[PHI: r2
      0x009f: PHI (r2v15 java.util.regex.Matcher) = (r2v10 java.util.regex.Matcher), (r2v8 java.util.regex.Matcher) binds: [B:26:0x0095, B:22:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7  */
    @Nullable
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SimpleCacheSpan m2842g(File file, long j, long j2, CachedContentIndex cachedContentIndex) throws NumberFormatException {
        File file2;
        long j3;
        String strGroup;
        File fileM2843h;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            String name2 = file.getName();
            Matcher matcher = f6518q.matcher(name2);
            if (matcher.matches()) {
                strGroup = matcher.group(1);
                Objects.requireNonNull(strGroup);
                int i = Util2.f6708a;
                int length = strGroup.length();
                int iEnd = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (strGroup.charAt(i3) == '%') {
                        i2++;
                    }
                }
                if (i2 != 0) {
                    int i4 = length - (i2 * 2);
                    StringBuilder sb = new StringBuilder(i4);
                    Matcher matcher2 = Util2.f6714g.matcher(strGroup);
                    while (i2 > 0 && matcher2.find()) {
                        String strGroup2 = matcher2.group(1);
                        Objects.requireNonNull(strGroup2);
                        char c = (char) Integer.parseInt(strGroup2, 16);
                        sb.append((CharSequence) strGroup, iEnd, matcher2.start());
                        sb.append(c);
                        iEnd = matcher2.end();
                        i2--;
                    }
                    if (iEnd < length) {
                        sb.append((CharSequence) strGroup, iEnd, length);
                    }
                    strGroup = sb.length() != i4 ? null : sb.toString();
                }
                if (strGroup != null) {
                    fileM2843h = null;
                    if (fileM2843h != null) {
                        return null;
                    }
                    file2 = fileM2843h;
                    name = fileM2843h.getName();
                } else {
                    File parentFile = file.getParentFile();
                    AnimatableValueParser.m438H(parentFile);
                    int i5 = cachedContentIndex.m2796d(strGroup).f6471a;
                    String strGroup3 = matcher.group(2);
                    Objects.requireNonNull(strGroup3);
                    long j4 = Long.parseLong(strGroup3);
                    String strGroup4 = matcher.group(3);
                    Objects.requireNonNull(strGroup4);
                    fileM2843h = m2843h(parentFile, i5, j4, Long.parseLong(strGroup4));
                    if (!file.renameTo(fileM2843h)) {
                    }
                    if (fileM2843h != null) {
                    }
                }
            } else {
                matcher = f6517p.matcher(name2);
                if (matcher.matches()) {
                    strGroup = matcher.group(1);
                    Objects.requireNonNull(strGroup);
                }
                if (strGroup != null) {
                }
            }
        }
        Matcher matcher3 = f6519r.matcher(name);
        if (!matcher3.matches()) {
            return null;
        }
        String strGroup5 = matcher3.group(1);
        Objects.requireNonNull(strGroup5);
        String str = cachedContentIndex.f6479b.get(Integer.parseInt(strGroup5));
        if (str == null) {
            return null;
        }
        long length2 = j == -1 ? file2.length() : j;
        if (length2 == 0) {
            return null;
        }
        String strGroup6 = matcher3.group(2);
        Objects.requireNonNull(strGroup6);
        long j5 = Long.parseLong(strGroup6);
        if (j2 == -9223372036854775807L) {
            String strGroup7 = matcher3.group(3);
            Objects.requireNonNull(strGroup7);
            j3 = Long.parseLong(strGroup7);
        } else {
            j3 = j2;
        }
        return new SimpleCacheSpan(str, j5, length2, j3, file2);
    }

    /* renamed from: h */
    public static File m2843h(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(i);
        sb.append(".");
        sb.append(j);
        sb.append(".");
        sb.append(j2);
        sb.append(".v3.exo");
        return new File(file, sb.toString());
    }
}

package p007b.p109f.p190m;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p190m.ApkSoSource;
import p007b.p109f.p190m.UnpackingSoSource;

/* compiled from: ExtractFromZipSoSource.java */
/* renamed from: b.f.m.f, reason: use source file name */
/* loaded from: classes3.dex */
public class ExtractFromZipSoSource extends UnpackingSoSource {

    /* renamed from: f */
    public final File f4325f;

    /* renamed from: g */
    public final String f4326g;

    /* compiled from: ExtractFromZipSoSource.java */
    /* renamed from: b.f.m.f$b */
    public static final class b extends UnpackingSoSource.b implements Comparable {

        /* renamed from: l */
        public final ZipEntry f4327l;

        /* renamed from: m */
        public final int f4328m;

        public b(String str, ZipEntry zipEntry, int i) {
            super(str, String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())));
            this.f4327l = zipEntry;
            this.f4328m = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f4353j.compareTo(((b) obj).f4353j);
        }
    }

    /* compiled from: ExtractFromZipSoSource.java */
    /* renamed from: b.f.m.f$c */
    public class c extends UnpackingSoSource.f {

        /* renamed from: j */
        public b[] f4329j;

        /* renamed from: k */
        public final ZipFile f4330k;

        /* renamed from: l */
        public final UnpackingSoSource f4331l;

        /* compiled from: ExtractFromZipSoSource.java */
        /* renamed from: b.f.m.f$c$a */
        public final class a extends UnpackingSoSource.e {

            /* renamed from: j */
            public int f4333j;

            public a(a aVar) {
            }

            @Override // p007b.p109f.p190m.UnpackingSoSource.e
            /* renamed from: a */
            public boolean mo1575a() {
                c.this.m1577c();
                return this.f4333j < c.this.f4329j.length;
            }

            @Override // p007b.p109f.p190m.UnpackingSoSource.e
            /* renamed from: b */
            public UnpackingSoSource.d mo1576b() throws IOException {
                c.this.m1577c();
                c cVar = c.this;
                b[] bVarArr = cVar.f4329j;
                int i = this.f4333j;
                this.f4333j = i + 1;
                b bVar = bVarArr[i];
                InputStream inputStream = cVar.f4330k.getInputStream(bVar.f4327l);
                try {
                    return new UnpackingSoSource.d(bVar, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        public c(UnpackingSoSource unpackingSoSource) throws IOException {
            this.f4330k = new ZipFile(ExtractFromZipSoSource.this.f4325f);
            this.f4331l = unpackingSoSource;
        }

        @Override // p007b.p109f.p190m.UnpackingSoSource.f
        /* renamed from: a */
        public final UnpackingSoSource.c mo1573a() throws IOException {
            return new UnpackingSoSource.c(m1577c());
        }

        @Override // p007b.p109f.p190m.UnpackingSoSource.f
        /* renamed from: b */
        public final UnpackingSoSource.e mo1574b() throws IOException {
            return new a(null);
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final b[] m1577c() {
            int i;
            String strM886y;
            boolean z2;
            if (this.f4329j == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap map = new HashMap();
                Pattern patternCompile = Pattern.compile(ExtractFromZipSoSource.this.f4326g);
                String[] strArrM424C0 = AnimatableValueParser.m424C0();
                Enumeration<? extends ZipEntry> enumerationEntries = this.f4330k.entries();
                while (true) {
                    i = 0;
                    if (!enumerationEntries.hasMoreElements()) {
                        break;
                    }
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    Matcher matcher = patternCompile.matcher(zipEntryNextElement.getName());
                    if (matcher.matches()) {
                        String strGroup = matcher.group(1);
                        String strGroup2 = matcher.group(2);
                        while (true) {
                            if (i >= strArrM424C0.length) {
                                i = -1;
                                break;
                            }
                            if (strArrM424C0[i] != null && strGroup.equals(strArrM424C0[i])) {
                                break;
                            }
                            i++;
                        }
                        if (i >= 0) {
                            linkedHashSet.add(strGroup);
                            b bVar = (b) map.get(strGroup2);
                            if (bVar == null || i < bVar.f4328m) {
                                map.put(strGroup2, new b(strGroup2, zipEntryNextElement, i));
                            }
                        }
                    }
                }
                UnpackingSoSource unpackingSoSource = this.f4331l;
                Objects.requireNonNull(unpackingSoSource);
                b[] bVarArr = (b[]) map.values().toArray(new b[map.size()]);
                Arrays.sort(bVarArr);
                int i2 = 0;
                for (int i3 = 0; i3 < bVarArr.length; i3++) {
                    b bVar2 = bVarArr[i3];
                    ZipEntry zipEntry = bVar2.f4327l;
                    String str = bVar2.f4353j;
                    ApkSoSource.a aVar = (ApkSoSource.a) this;
                    String name = zipEntry.getName();
                    if (str.equals(ApkSoSource.this.f4345d)) {
                        ApkSoSource.this.f4345d = null;
                        strM886y = String.format("allowing consideration of corrupted lib %s", str);
                    } else if ((aVar.f4314o & 1) == 0) {
                        strM886y = outline.m886y("allowing consideration of ", name, ": self-extraction preferred");
                    } else {
                        File file = new File(aVar.f4313n, str);
                        if (file.isFile()) {
                            long length = file.length();
                            long size = zipEntry.getSize();
                            if (length != size) {
                                strM886y = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                            } else {
                                strM886y = outline.m886y("not allowing consideration of ", name, ": deferring to libdir");
                                z2 = false;
                                Log.d("ApkSoSource", strM886y);
                                if (z2) {
                                    bVarArr[i3] = null;
                                } else {
                                    i2++;
                                }
                            }
                        } else {
                            strM886y = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                        }
                    }
                    z2 = true;
                    Log.d("ApkSoSource", strM886y);
                    if (z2) {
                    }
                }
                b[] bVarArr2 = new b[i2];
                int i4 = 0;
                while (i < bVarArr.length) {
                    b bVar3 = bVarArr[i];
                    if (bVar3 != null) {
                        bVarArr2[i4] = bVar3;
                        i4++;
                    }
                    i++;
                }
                this.f4329j = bVarArr2;
            }
            return this.f4329j;
        }

        @Override // p007b.p109f.p190m.UnpackingSoSource.f, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f4330k.close();
        }
    }

    public ExtractFromZipSoSource(Context context, String str, File file, String str2) {
        super(context, str);
        this.f4325f = file;
        this.f4326g = str2;
    }
}

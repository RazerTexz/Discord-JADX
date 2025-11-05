package b.f.m;

import android.content.Context;
import android.util.Log;
import b.f.m.a;
import b.f.m.m;
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

/* compiled from: ExtractFromZipSoSource.java */
/* loaded from: classes3.dex */
public class f extends m {
    public final File f;
    public final String g;

    /* compiled from: ExtractFromZipSoSource.java */
    public static final class b extends m.b implements Comparable {
        public final ZipEntry l;
        public final int m;

        public b(String str, ZipEntry zipEntry, int i) {
            super(str, String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())));
            this.l = zipEntry;
            this.m = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.j.compareTo(((b) obj).j);
        }
    }

    /* compiled from: ExtractFromZipSoSource.java */
    public class c extends m.f {
        public b[] j;
        public final ZipFile k;
        public final m l;

        /* compiled from: ExtractFromZipSoSource.java */
        public final class a extends m.e {
            public int j;

            public a(a aVar) {
            }

            @Override // b.f.m.m.e
            public boolean a() {
                c.this.c();
                return this.j < c.this.j.length;
            }

            @Override // b.f.m.m.e
            public m.d b() throws IOException {
                c.this.c();
                c cVar = c.this;
                b[] bVarArr = cVar.j;
                int i = this.j;
                this.j = i + 1;
                b bVar = bVarArr[i];
                InputStream inputStream = cVar.k.getInputStream(bVar.l);
                try {
                    return new m.d(bVar, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        public c(m mVar) throws IOException {
            this.k = new ZipFile(f.this.f);
            this.l = mVar;
        }

        @Override // b.f.m.m.f
        public final m.c a() throws IOException {
            return new m.c(c());
        }

        @Override // b.f.m.m.f
        public final m.e b() throws IOException {
            return new a(null);
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final b[] c() {
            int i;
            String strY;
            boolean z2;
            if (this.j == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap map = new HashMap();
                Pattern patternCompile = Pattern.compile(f.this.g);
                String[] strArrC0 = b.c.a.a0.d.C0();
                Enumeration<? extends ZipEntry> enumerationEntries = this.k.entries();
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
                            if (i >= strArrC0.length) {
                                i = -1;
                                break;
                            }
                            if (strArrC0[i] != null && strGroup.equals(strArrC0[i])) {
                                break;
                            }
                            i++;
                        }
                        if (i >= 0) {
                            linkedHashSet.add(strGroup);
                            b bVar = (b) map.get(strGroup2);
                            if (bVar == null || i < bVar.m) {
                                map.put(strGroup2, new b(strGroup2, zipEntryNextElement, i));
                            }
                        }
                    }
                }
                m mVar = this.l;
                Objects.requireNonNull(mVar);
                b[] bVarArr = (b[]) map.values().toArray(new b[map.size()]);
                Arrays.sort(bVarArr);
                int i2 = 0;
                for (int i3 = 0; i3 < bVarArr.length; i3++) {
                    b bVar2 = bVarArr[i3];
                    ZipEntry zipEntry = bVar2.l;
                    String str = bVar2.j;
                    a.C0078a c0078a = (a.C0078a) this;
                    String name = zipEntry.getName();
                    if (str.equals(b.f.m.a.this.d)) {
                        b.f.m.a.this.d = null;
                        strY = String.format("allowing consideration of corrupted lib %s", str);
                    } else if ((c0078a.o & 1) == 0) {
                        strY = b.d.b.a.a.y("allowing consideration of ", name, ": self-extraction preferred");
                    } else {
                        File file = new File(c0078a.n, str);
                        if (file.isFile()) {
                            long length = file.length();
                            long size = zipEntry.getSize();
                            if (length != size) {
                                strY = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                            } else {
                                strY = b.d.b.a.a.y("not allowing consideration of ", name, ": deferring to libdir");
                                z2 = false;
                                Log.d("ApkSoSource", strY);
                                if (z2) {
                                    bVarArr[i3] = null;
                                } else {
                                    i2++;
                                }
                            }
                        } else {
                            strY = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                        }
                    }
                    z2 = true;
                    Log.d("ApkSoSource", strY);
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
                this.j = bVarArr2;
            }
            return this.j;
        }

        @Override // b.f.m.m.f, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.k.close();
        }
    }

    public f(Context context, String str, File file, String str2) {
        super(context, str);
        this.f = file;
        this.g = str2;
    }
}

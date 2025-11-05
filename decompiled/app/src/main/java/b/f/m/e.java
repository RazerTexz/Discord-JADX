package b.f.m;

import android.content.Context;
import b.f.m.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: ExoSoSource.java */
/* loaded from: classes3.dex */
public final class e extends m {

    /* compiled from: ExoSoSource.java */
    public final class b extends m.f {
        public final c[] j;

        /* compiled from: ExoSoSource.java */
        public final class a extends m.e {
            public int j;

            public a(a aVar) {
            }

            @Override // b.f.m.m.e
            public boolean a() {
                return this.j < b.this.j.length;
            }

            @Override // b.f.m.m.e
            public m.d b() throws IOException {
                c[] cVarArr = b.this.j;
                int i = this.j;
                this.j = i + 1;
                c cVar = cVarArr[i];
                FileInputStream fileInputStream = new FileInputStream(cVar.l);
                try {
                    return new m.d(cVar, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d8, code lost:
        
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r10 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(e eVar, m mVar) throws IOException {
            boolean z2;
            Context context = eVar.c;
            StringBuilder sbU = b.d.b.a.a.U("/data/local/tmp/exopackage/");
            sbU.append(context.getPackageName());
            sbU.append("/native-libs/");
            File file = new File(sbU.toString());
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            loop0: for (String str : b.c.a.a0.d.C0()) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        bufferedReader.close();
                                        fileReader.close();
                                        break;
                                    }
                                    if (line.length() != 0) {
                                        int iIndexOf = line.indexOf(32);
                                        if (iIndexOf == -1) {
                                            break loop0;
                                        }
                                        String str2 = line.substring(0, iIndexOf) + ".so";
                                        int size = arrayList.size();
                                        int i = 0;
                                        while (true) {
                                            if (i >= size) {
                                                z2 = false;
                                                break;
                                            } else {
                                                if (((c) arrayList.get(i)).j.equals(str2)) {
                                                    z2 = true;
                                                    break;
                                                }
                                                i++;
                                            }
                                        }
                                        if (!z2) {
                                            String strSubstring = line.substring(iIndexOf + 1);
                                            arrayList.add(new c(str2, strSubstring, new File(file2, strSubstring)));
                                        }
                                    }
                                } finally {
                                }
                            }
                        } finally {
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.j = (c[]) arrayList.toArray(new c[arrayList.size()]);
        }

        @Override // b.f.m.m.f
        public m.c a() throws IOException {
            return new m.c(this.j);
        }

        @Override // b.f.m.m.f
        public m.e b() throws IOException {
            return new a(null);
        }
    }

    /* compiled from: ExoSoSource.java */
    public static final class c extends m.b {
        public final File l;

        public c(String str, String str2, File file) {
            super(str, str2);
            this.l = file;
        }
    }

    public e(Context context, String str) {
        super(context, str);
    }

    @Override // b.f.m.m
    public m.f i() throws IOException {
        return new b(this, this);
    }
}

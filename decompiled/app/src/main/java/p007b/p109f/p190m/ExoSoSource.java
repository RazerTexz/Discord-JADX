package p007b.p109f.p190m;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p190m.UnpackingSoSource;

/* compiled from: ExoSoSource.java */
/* renamed from: b.f.m.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExoSoSource extends UnpackingSoSource {

    /* compiled from: ExoSoSource.java */
    /* renamed from: b.f.m.e$b */
    public final class b extends UnpackingSoSource.f {

        /* renamed from: j */
        public final c[] f4321j;

        /* compiled from: ExoSoSource.java */
        /* renamed from: b.f.m.e$b$a */
        public final class a extends UnpackingSoSource.e {

            /* renamed from: j */
            public int f4322j;

            public a(a aVar) {
            }

            @Override // p007b.p109f.p190m.UnpackingSoSource.e
            /* renamed from: a */
            public boolean mo1575a() {
                return this.f4322j < b.this.f4321j.length;
            }

            @Override // p007b.p109f.p190m.UnpackingSoSource.e
            /* renamed from: b */
            public UnpackingSoSource.d mo1576b() throws IOException {
                c[] cVarArr = b.this.f4321j;
                int i = this.f4322j;
                this.f4322j = i + 1;
                c cVar = cVarArr[i];
                FileInputStream fileInputStream = new FileInputStream(cVar.f4324l);
                try {
                    return new UnpackingSoSource.d(cVar, fileInputStream);
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
        public b(ExoSoSource exoSoSource, UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z2;
            Context context = exoSoSource.f4344c;
            StringBuilder sbM833U = outline.m833U("/data/local/tmp/exopackage/");
            sbM833U.append(context.getPackageName());
            sbM833U.append("/native-libs/");
            File file = new File(sbM833U.toString());
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            loop0: for (String str : AnimatableValueParser.m424C0()) {
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
                                                if (((c) arrayList.get(i)).f4353j.equals(str2)) {
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
            this.f4321j = (c[]) arrayList.toArray(new c[arrayList.size()]);
        }

        @Override // p007b.p109f.p190m.UnpackingSoSource.f
        /* renamed from: a */
        public UnpackingSoSource.c mo1573a() throws IOException {
            return new UnpackingSoSource.c(this.f4321j);
        }

        @Override // p007b.p109f.p190m.UnpackingSoSource.f
        /* renamed from: b */
        public UnpackingSoSource.e mo1574b() throws IOException {
            return new a(null);
        }
    }

    /* compiled from: ExoSoSource.java */
    /* renamed from: b.f.m.e$c */
    public static final class c extends UnpackingSoSource.b {

        /* renamed from: l */
        public final File f4324l;

        public c(String str, String str2, File file) {
            super(str, str2);
            this.f4324l = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // p007b.p109f.p190m.UnpackingSoSource
    /* renamed from: i */
    public UnpackingSoSource.f mo1566i() throws IOException {
        return new b(this, this);
    }
}

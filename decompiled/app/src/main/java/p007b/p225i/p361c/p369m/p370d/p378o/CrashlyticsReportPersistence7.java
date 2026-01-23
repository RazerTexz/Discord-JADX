package p007b.p225i.p361c.p369m.p370d.p378o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;

/* JADX INFO: renamed from: b.i.c.m.d.o.g, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsReportPersistence7 {

    /* JADX INFO: renamed from: a */
    public static final Charset f12672a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b */
    public static final int f12673b = 15;

    /* JADX INFO: renamed from: c */
    public static final CrashlyticsReportJsonTransform8 f12674c = new CrashlyticsReportJsonTransform8();

    /* JADX INFO: renamed from: d */
    public static final Comparator<? super File> f12675d = CrashlyticsReportPersistence5.f12670j;

    /* JADX INFO: renamed from: e */
    public static final FilenameFilter f12676e = CrashlyticsReportPersistence6.f12671a;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final AtomicInteger f12677f = new AtomicInteger(0);

    /* JADX INFO: renamed from: g */
    @NonNull
    public final File f12678g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final File f12679h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final File f12680i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final File f12681j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final SettingsDataProvider f12682k;

    public CrashlyticsReportPersistence7(@NonNull File file, @NonNull SettingsDataProvider settingsDataProvider) {
        File file2 = new File(file, "report-persistence");
        this.f12678g = new File(file2, "sessions");
        this.f12679h = new File(file2, "priority-reports");
        this.f12680i = new File(file2, "reports");
        this.f12681j = new File(file2, "native-reports");
        this.f12682k = settingsDataProvider;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static List<File> m6624a(@NonNull List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int size = 0;
        for (List<File> list : listArr) {
            size += list.size();
        }
        arrayList.ensureCapacity(size);
        for (List<File> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    @NonNull
    /* JADX INFO: renamed from: d */
    public static List<File> m6625d(@NonNull File file) {
        return m6626f(file, null);
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static List<File> m6626f(@NonNull File file, @Nullable FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return fileArrListFiles != null ? Arrays.asList(fileArrListFiles) : Collections.emptyList();
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public static List<File> m6627g(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return fileArrListFiles != null ? Arrays.asList(fileArrListFiles) : Collections.emptyList();
    }

    @NonNull
    /* JADX INFO: renamed from: i */
    public static File m6628i(@NonNull File file) throws IOException {
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    @NonNull
    /* JADX INFO: renamed from: j */
    public static String m6629j(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f12672a);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m6630k(@Nullable File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m6630k(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: renamed from: l */
    public static void m6631l(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f12672a);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6632b() {
        Iterator it = ((ArrayList) m6634e()).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6633c(String str) {
        CrashlyticsReportPersistence crashlyticsReportPersistence = new CrashlyticsReportPersistence(str);
        Iterator it = ((ArrayList) m6624a(m6627g(this.f12679h, crashlyticsReportPersistence), m6627g(this.f12681j, crashlyticsReportPersistence), m6627g(this.f12680i, crashlyticsReportPersistence))).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    @NonNull
    /* JADX INFO: renamed from: e */
    public final List<File> m6634e() {
        List[] listArr = {m6624a(m6625d(this.f12679h), m6625d(this.f12681j)), m6625d(this.f12680i)};
        for (int i = 0; i < 2; i++) {
            Collections.sort(listArr[i], f12675d);
        }
        return m6624a(listArr);
    }

    @NonNull
    /* JADX INFO: renamed from: h */
    public final File m6635h(@NonNull String str) {
        return new File(this.f12678g, str);
    }
}

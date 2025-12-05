package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.h.l.k2 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3719k2 implements InterfaceC3914z2 {

    /* renamed from: j */
    public final Context f10051j;

    public C3719k2(Context context) {
        this.f10051j = context;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2
    /* renamed from: a */
    public final Object mo4555a() {
        AbstractC3888x2 c3901y2;
        Context contextCreateDeviceProtectedStorageContext = this.f10051j;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if (!((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            return C3875w2.f10378j;
        }
        if (C3874w1.m5341a() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
            contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
            c3901y2 = file.exists() ? new C3901y2(file) : C3875w2.f10378j;
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            c3901y2 = C3875w2.f10378j;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
        if (!c3901y2.mo5342b()) {
            return C3875w2.f10378j;
        }
        File file2 = (File) c3901y2.mo5343c();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
            try {
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String strValueOf = String.valueOf(file2);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                        sb.append("Parsed ");
                        sb.append(strValueOf);
                        Log.i("HermeticFileOverrides", sb.toString());
                        C3678h2 c3678h2 = new C3678h2(map);
                        bufferedReader.close();
                        return new C3901y2(c3678h2);
                    }
                    String[] strArrSplit = line.split(" ", 3);
                    if (strArrSplit.length != 3) {
                        Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                    } else {
                        String str3 = strArrSplit[0];
                        String strDecode = Uri.decode(strArrSplit[1]);
                        String strDecode2 = Uri.decode(strArrSplit[2]);
                        if (!map.containsKey(str3)) {
                            map.put(str3, new HashMap());
                        }
                        ((Map) map.get(str3)).put(strDecode, strDecode2);
                    }
                }
            } finally {
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}

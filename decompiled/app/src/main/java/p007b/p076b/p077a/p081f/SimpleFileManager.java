package p007b.p076b.p077a.p081f;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.managers.FileManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SimpleFileManager.kt */
/* renamed from: b.b.a.f.b, reason: use source file name */
/* loaded from: classes3.dex */
public class SimpleFileManager implements FileManager {

    /* renamed from: a */
    public final Context f2199a;

    /* renamed from: b */
    public final String f2200b;

    /* renamed from: c */
    public final String f2201c;

    public SimpleFileManager(Context context, String str, String str2, int i) {
        String str3;
        String string = null;
        if ((i & 2) != 0) {
            str3 = context.getPackageName() + ".file-provider";
        } else {
            str3 = null;
        }
        if ((i & 4) != 0) {
            string = context.getString(C11170R.h.discord);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.discord)");
        }
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str3, "providerAuthority");
        Intrinsics3.checkNotNullParameter(string, "imageDirName");
        this.f2199a = context;
        this.f2200b = str3;
        this.f2201c = string;
    }

    @Override // com.lytefast.flexinput.managers.FileManager
    /* renamed from: a */
    public Uri mo408a(Context context, File file) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(file, "file");
        Uri uriForFile = FileProvider.getUriForFile(context, this.f2200b, file);
        Intrinsics3.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi… providerAuthority, file)");
        return uriForFile;
    }

    @Override // com.lytefast.flexinput.managers.FileManager
    /* renamed from: b */
    public File mo409b() {
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        Context context = this.f2199a;
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), this.f2201c);
        file.mkdirs();
        if (!file.exists()) {
            file = context.getFilesDir();
            Intrinsics3.checkNotNullExpressionValue(file, "context.filesDir");
        }
        return new File(file, outline.m883w(str, ".jpg"));
    }
}

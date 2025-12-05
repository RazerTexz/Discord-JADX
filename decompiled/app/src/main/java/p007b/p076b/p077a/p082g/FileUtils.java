package p007b.p076b.p077a.p082g;

import android.net.Uri;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FileUtils.kt */
/* renamed from: b.b.a.g.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class FileUtils {
    /* renamed from: a */
    public static final Attachment<File> m410a(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$toAttachment");
        long jHashCode = file.hashCode();
        Uri uriFromFile = Uri.fromFile(file);
        Intrinsics3.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(this)");
        String name = file.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "this.name");
        return new Attachment<>(jHashCode, uriFromFile, name, file, false, 16, null);
    }
}

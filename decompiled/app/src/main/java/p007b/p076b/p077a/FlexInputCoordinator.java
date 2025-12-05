package p007b.p076b.p077a;

import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: FlexInputCoordinator.kt */
/* renamed from: b.b.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public interface FlexInputCoordinator<T> {
    /* renamed from: b */
    SelectionAggregator<Attachment<T>> mo396b();

    /* renamed from: f */
    void mo397f(Attachment<? extends T> attachment);

    FileManager getFileManager();

    boolean hasMediaPermissions();

    void requestMediaPermissions(Function0<Unit> function0);
}

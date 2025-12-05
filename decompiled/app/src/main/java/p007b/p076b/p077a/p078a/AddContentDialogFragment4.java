package p007b.p076b.p077a.p078a;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;

/* compiled from: AddContentDialogFragment.kt */
/* renamed from: b.b.a.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AddContentDialogFragment4 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AddContentDialogFragment f2131j;

    public AddContentDialogFragment4(AddContentDialogFragment addContentDialogFragment) {
        this.f2131j = addContentDialogFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SelectionAggregator<Attachment<Object>> selectionAggregator = this.f2131j.selectionAggregator;
        if ((selectionAggregator != null ? selectionAggregator.getSize() : 0) > 0) {
            FloatingActionButton floatingActionButton = this.f2131j.actionButton;
            if (floatingActionButton != null) {
                floatingActionButton.show();
                return;
            }
            return;
        }
        FloatingActionButton floatingActionButton2 = this.f2131j.actionButton;
        if (floatingActionButton2 != null) {
            floatingActionButton2.hide();
        }
    }
}

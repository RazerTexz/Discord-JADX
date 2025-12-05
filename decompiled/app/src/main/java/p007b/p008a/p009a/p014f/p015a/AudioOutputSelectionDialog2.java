package p007b.p008a.p009a.p014f.p015a;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* compiled from: AudioOutputSelectionDialog.kt */
/* renamed from: b.a.a.f.a.b, reason: use source file name */
/* loaded from: classes.dex */
public final class AudioOutputSelectionDialog2 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ AudioOutputSelectionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioOutputSelectionDialog2(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        super(1);
        this.this$0 = audioOutputSelectionDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Long l) {
        this.this$0.requireDialog().cancel();
        return Unit.f27425a;
    }
}

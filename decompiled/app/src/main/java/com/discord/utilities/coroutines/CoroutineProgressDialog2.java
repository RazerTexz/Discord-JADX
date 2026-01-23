package com.discord.utilities.coroutines;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import com.discord.C5419R;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p025i.ViewGenericLoadingBinding;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1, reason: use source file name */
/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m10084c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1", m10085f = "CoroutineProgressDialog.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class CoroutineProgressDialog2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super AlertDialog>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineContext $myCoroutineContext;
    public int label;

    /* JADX INFO: renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1$1 */
    /* JADX INFO: compiled from: CoroutineProgressDialog.kt */
    public static final class DialogInterfaceOnCancelListenerC67391 implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC67391() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            C3404f.m4339s(CoroutineProgressDialog2.this.$myCoroutineContext, null, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog2(Context context, CoroutineContext coroutineContext, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$myCoroutineContext = coroutineContext;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new CoroutineProgressDialog2(this.$context, this.$myCoroutineContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AlertDialog> continuation) {
        return ((CoroutineProgressDialog2) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        View viewInflate = LayoutInflater.from(this.$context).inflate(C5419R.layout.view_generic_loading, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        Intrinsics3.checkNotNullExpressionValue(new ViewGenericLoadingBinding(frameLayout), "ViewGenericLoadingBindin…utInflater.from(context))");
        return new AlertDialog.Builder(this.$context, 2131951632).setView(frameLayout).setCancelable(true).setOnCancelListener(new DialogInterfaceOnCancelListenerC67391()).show();
    }
}

package com.discord.utilities.coroutines;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import b.a.i.j2;
import b.i.a.f.e.o.f;
import com.discord.R;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineProgressDialog.kt */
@e(c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1", f = "CoroutineProgressDialog.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CoroutineProgressDialog$withCancellableProgressDialog$dialog$1 extends k implements Function2<CoroutineScope, Continuation<? super AlertDialog>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineContext $myCoroutineContext;
    public int label;

    /* compiled from: CoroutineProgressDialog.kt */
    /* renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            f.s(CoroutineProgressDialog$withCancellableProgressDialog$dialog$1.this.$myCoroutineContext, null, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(Context context, CoroutineContext coroutineContext, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$myCoroutineContext = coroutineContext;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(this.$context, this.$myCoroutineContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AlertDialog> continuation) {
        return ((CoroutineProgressDialog$withCancellableProgressDialog$dialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        View viewInflate = LayoutInflater.from(this.$context).inflate(R.layout.view_generic_loading, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        m.checkNotNullExpressionValue(new j2(frameLayout), "ViewGenericLoadingBindin…utInflater.from(context))");
        return new AlertDialog.Builder(this.$context, 2131951632).setView(frameLayout).setCancelable(true).setOnCancelListener(new AnonymousClass1()).show();
    }
}

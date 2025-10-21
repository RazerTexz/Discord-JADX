package com.discord.widgets.contact_sync;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: AddFriendsFailed.kt */
/* renamed from: com.discord.widgets.contact_sync.AddFriendsFailed$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class AddFriendsFailed2 extends FunctionReferenceImpl implements Function1<View, ViewDialogConfirmationBinding> {
    public static final AddFriendsFailed2 INSTANCE = new AddFriendsFailed2();

    public AddFriendsFailed2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewDialogConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewDialogConfirmationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.a(view);
    }
}

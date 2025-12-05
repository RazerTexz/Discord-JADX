package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: WidgetChatInputAttachments.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1 */
/* loaded from: classes2.dex */
public final class C7750x30afbd36<T> implements SelectionCoordinator.ItemSelectionListener<T> {
    private final /* synthetic */ SelectionCoordinator.ItemSelectionListener<? super T> $$delegate_0;
    public final /* synthetic */ SelectionCoordinator.ItemSelectionListener $oldItemSelectionListener;
    public final /* synthetic */ WidgetChatInputAttachments.C77491.AnonymousClass1 this$0;

    public C7750x30afbd36(WidgetChatInputAttachments.C77491.AnonymousClass1 anonymousClass1, SelectionCoordinator.ItemSelectionListener itemSelectionListener) {
        this.this$0 = anonymousClass1;
        this.$oldItemSelectionListener = itemSelectionListener;
        this.$$delegate_0 = itemSelectionListener;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public /* bridge */ /* synthetic */ void onItemSelected(Object obj) {
        onItemSelected((Attachment) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public void onItemUnselected(Attachment item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        this.$$delegate_0.onItemUnselected(item);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public /* bridge */ /* synthetic */ void onItemUnselected(Object obj) {
        onItemUnselected((Attachment) obj);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
    public void unregister() {
        this.$$delegate_0.unregister();
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    public void onItemSelected(Attachment item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        WidgetChatInputAttachments.C77491.AnonymousClass1.access$track(this.this$0, item);
        this.$oldItemSelectionListener.onItemSelected(item);
    }
}

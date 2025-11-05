package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.stores.StoreThreadDraft;

/* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$2 implements View.OnFocusChangeListener {
    public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState$inlined;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$2(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$storeThreadDraft$inlined = storeThreadDraft;
        this.$draftState$inlined = threadDraftState;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2 || !this.$draftState$inlined.getShouldDisplayNameError()) {
            return;
        }
        this.$storeThreadDraft$inlined.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(this.$draftState$inlined, false, null, null, false, false, 15, null));
    }
}

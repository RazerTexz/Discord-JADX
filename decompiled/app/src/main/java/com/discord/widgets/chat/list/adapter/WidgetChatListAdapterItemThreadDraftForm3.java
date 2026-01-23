package com.discord.widgets.chat.list.adapter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.discord.stores.StoreThreadDraft;
import com.discord.widgets.chat.input.AppFlexInputViewModel;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm3 implements TextView.OnEditorActionListener {
    public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState$inlined;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm3(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$storeThreadDraft$inlined = storeThreadDraft;
        this.$draftState$inlined = threadDraftState;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        AppFlexInputViewModel flexInputViewModel;
        if (i != 5 || (flexInputViewModel = this.this$0.getFlexInputViewModel()) == null) {
            return false;
        }
        flexInputViewModel.focus();
        return false;
    }
}

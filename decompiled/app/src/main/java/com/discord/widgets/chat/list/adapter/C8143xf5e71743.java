package com.discord.widgets.chat.list.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreThreadDraft;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8143xf5e71743 implements TextWatcher {
    public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState$inlined;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public C8143xf5e71743(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$storeThreadDraft$inlined = storeThreadDraft;
        this.$draftState$inlined = threadDraftState;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(Editable s2) {
        StoreThreadDraft storeThreadDraft = this.$storeThreadDraft$inlined;
        StoreThreadDraft.ThreadDraftState threadDraftState = this.$draftState$inlined;
        String string = s2 != null ? s2.toString() : null;
        boolean z2 = true;
        if (!this.$draftState$inlined.getShouldDisplayNameError() || s2 == null) {
            z2 = false;
        } else {
            if (!(s2.length() == 0)) {
            }
        }
        storeThreadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, false, null, string, false, z2, 11, null));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}

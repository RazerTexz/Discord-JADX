package com.discord.widgets.notice;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$2, reason: use source file name */
/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup4 implements View.OnClickListener {
    public final /* synthetic */ FragmentActivity $activity$inlined;
    public final /* synthetic */ View $view;
    public final /* synthetic */ NoticePopup2 this$0;

    public NoticePopup4(View view, NoticePopup2 noticePopup2, FragmentActivity fragmentActivity) {
        this.$view = view;
        this.this$0 = noticePopup2;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NoticePopup.access$dismiss(NoticePopup.INSTANCE, this.this$0.$noticeName);
        this.this$0.$onClickTopRightIcon.invoke(this.$view);
    }
}

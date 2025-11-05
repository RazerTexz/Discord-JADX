package com.discord.widgets.channels;

import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.TextView;
import com.discord.models.member.GuildMember;
import com.discord.utilities.dimen.DimenUtils;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: View.kt */
/* loaded from: classes2.dex */
public final class UserAkaView$configure$$inlined$doOnPreDraw$1 implements Runnable {
    public final /* synthetic */ List $guildMembers$inlined;
    public final /* synthetic */ View $this_doOnPreDraw;
    public final /* synthetic */ UserAkaView this$0;

    public UserAkaView$configure$$inlined$doOnPreDraw$1(View view, UserAkaView userAkaView, List list) {
        this.$this_doOnPreDraw = view;
        this.this$0 = userAkaView;
        this.$guildMembers$inlined = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Number numberValueOf;
        List list = this.$guildMembers$inlined;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String nick = ((GuildMember) it.next()).getNick();
            if (nick != null) {
                arrayList.add(nick);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!t.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        if (this.this$0.getPileItems().isEmpty()) {
            m.checkNotNullExpressionValue(UserAkaView.access$getBinding$p(this.this$0).e, "binding.spaceForMeasuring");
            numberValueOf = Float.valueOf(r1.getMeasuredWidth());
        } else {
            numberValueOf = Integer.valueOf(DimenUtils.dpToPixels(8));
        }
        TextView textView = UserAkaView.access$getBinding$p(this.this$0).f2162b;
        m.checkNotNullExpressionValue(textView, "binding.akaText");
        float measuredWidth = textView.getMeasuredWidth();
        m.checkNotNullExpressionValue(UserAkaView.access$getBinding$p(this.this$0).c, "binding.avatarsPileView");
        float fFloatValue = numberValueOf.floatValue() + measuredWidth + r4.getMeasuredWidth();
        SpannableString spannableString = new SpannableString(u.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null));
        spannableString.setSpan(new LeadingMarginSpan.Standard((int) fFloatValue, 0), 0, spannableString.length(), 33);
        TextView textView2 = UserAkaView.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textView2, "binding.nicknames");
        textView2.setText(spannableString);
        TextView textView3 = UserAkaView.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textView3, "binding.nicknames");
        textView3.setVisibility(arrayList2.isEmpty() ^ true ? 0 : 8);
    }
}

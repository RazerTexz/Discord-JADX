package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.application.Application;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ViewHolderGameRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderGameRichPresence extends ViewHolderUserRichPresence {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderGameRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, view2, button, button2, 1);
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceDetails");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(textView5, "richPresenceState");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(button, "richPresencePrimaryButton");
        Intrinsics3.checkNotNullParameter(button2, "richPresenceSecondaryButton");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configureTextUi(Activity model, StreamContext streamContext) {
        String string;
        Context context;
        if (model == null) {
            throw new IllegalArgumentException("model must not be null");
        }
        String state = model.getState();
        if (state != null) {
            ActivityParty party = model.getParty();
            if (party != null) {
                PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
                CharSequence charSequenceM216h = (presenceUtils.getMaxSize(party) == 0 || (context = getRoot().getContext()) == null) ? null : FormatUtils.m216h(context, C5419R.string.user_activity_state_size, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, null, 4);
                if (charSequenceM216h == null) {
                    charSequenceM216h = "";
                }
                String str = state + ' ' + charSequenceM216h;
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                string = Strings4.trim(str).toString();
            }
        } else {
            string = null;
        }
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context2 = getRichPresenceHeader().getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context2, model));
        getRichPresenceTitle().setText(model.getName());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, model.getDetails());
        }
        TextView richPresenceState = getRichPresenceState();
        if (richPresenceState != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceState, string);
        }
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        String applicationIcon$default;
        Application primaryApplication;
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        super.configureUi(fragmentManager, streamContext, isMe, user, applicationContext, richPresence, userInSameVoiceChannel);
        if (getRichPresenceImageLarge().getVisibility() != 0) {
            if (richPresence == null || (primaryApplication = richPresence.getPrimaryApplication()) == null) {
                applicationIcon$default = null;
            } else {
                long id2 = primaryApplication.getId();
                String icon = primaryApplication.getIcon();
                if (icon == null) {
                    icon = "";
                }
                applicationIcon$default = IconUtils.getApplicationIcon$default(id2, icon, 0, 4, (Object) null);
            }
            getRichPresenceImageLarge().setVisibility(0);
            MGImages.setImage$default(getRichPresenceImageLarge(), applicationIcon$default, 0, 0, false, null, null, 124, null);
        }
    }
}

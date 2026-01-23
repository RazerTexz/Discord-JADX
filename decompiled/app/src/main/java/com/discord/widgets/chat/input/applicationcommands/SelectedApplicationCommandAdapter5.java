package com.discord.widgets.chat.input.applicationcommands;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ViewAppcommandsOptiontitleListitemBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.MentionUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandTitleAdapterItem, reason: use source file name */
/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter5 extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> {
    private final ViewAppcommandsOptiontitleListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter5(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(C5419R.layout.view_appcommands_optiontitle_listitem, selectedApplicationCommandAdapter);
        Intrinsics3.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.appcommands_optiontitle;
        TextView textView = (TextView) view.findViewById(C5419R.id.appcommands_optiontitle);
        if (textView != null) {
            i = C5419R.id.appcommands_optiontitle_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.appcommands_optiontitle_avatar);
            if (simpleDraweeView != null) {
                ViewAppcommandsOptiontitleListitemBinding viewAppcommandsOptiontitleListitemBinding = new ViewAppcommandsOptiontitleListitemBinding((ConstraintLayout) view, textView, simpleDraweeView);
                Intrinsics3.checkNotNullExpressionValue(viewAppcommandsOptiontitleListitemBinding, "ViewAppcommandsOptiontit…temBinding.bind(itemView)");
                this.binding = viewAppcommandsOptiontitleListitemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        onConfigure2(i, selectedApplicationCommandAdapter8);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandAdapter8 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StringBuilder sbM829Q = outline.m829Q(MentionUtils.SLASH_CHAR);
        sbM829Q.append(data.getTitle());
        String string = sbM829Q.toString();
        TextView textView = this.binding.f15372b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.appcommandsOptiontitle");
        textView.setText(string);
        this.binding.f15373c.setImageURI((String) null);
        this.binding.f15373c.clearColorFilter();
        Application application = data.getApplication();
        if (application != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f15373c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.appcommandsOptiontitleAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.f15371a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        int themedColor = ColorCompat.getThemedColor(constraintLayout, C5419R.attr.colorTextMuted);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView2 = this.binding.f15373c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.appcommandsOptiontitleAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView2, C5419R.drawable.ic_slash_command_24dp, (MGImages.ChangeDetector) null, 4, (Object) null);
        this.binding.f15373c.setColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP);
    }
}

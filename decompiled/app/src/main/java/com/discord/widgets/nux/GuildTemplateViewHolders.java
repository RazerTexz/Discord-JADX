package com.discord.widgets.nux;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder, reason: use source file name */
/* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateViewHolders extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateCardViewHolderBinding binding;
    private final GuildTemplatesAdapter.Callbacks callbacks;

    /* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder$bind$2 */
    /* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
    public static final class ViewOnClickListenerC91032 implements View.OnClickListener {
        public final /* synthetic */ GuildTemplates $guildTemplate;

        public ViewOnClickListenerC91032(GuildTemplates guildTemplates) {
            this.$guildTemplate = guildTemplates;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildTemplateViewHolders.this.getCallbacks().onTemplateClick(this.$guildTemplate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateViewHolders(NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding, GuildTemplatesAdapter.Callbacks callbacks) {
        super(nuxGuildTemplateCardViewHolderBinding.f15197a);
        Intrinsics3.checkNotNullParameter(nuxGuildTemplateCardViewHolderBinding, "binding");
        Intrinsics3.checkNotNullParameter(callbacks, "callbacks");
        this.binding = nuxGuildTemplateCardViewHolderBinding;
        this.callbacks = callbacks;
    }

    public final void bind(GuildTemplates guildTemplate) {
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        TextView textView = this.binding.f15199c;
        textView.setText(guildTemplate.getTitleRes());
        DrawableCompat.setCompoundDrawablesCompat(textView, guildTemplate.getDrawableRes(), 0, C5419R.drawable.icon_carrot, 0);
        this.binding.f15198b.setOnClickListener(new ViewOnClickListenerC91032(guildTemplate));
    }

    public final NuxGuildTemplateCardViewHolderBinding getBinding() {
        return this.binding;
    }

    public final GuildTemplatesAdapter.Callbacks getCallbacks() {
        return this.callbacks;
    }
}

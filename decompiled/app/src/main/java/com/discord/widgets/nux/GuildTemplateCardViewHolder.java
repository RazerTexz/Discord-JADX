package com.discord.widgets.nux;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import d0.z.d.m;

/* compiled from: GuildTemplateViewHolders.kt */
/* loaded from: classes2.dex */
public final class GuildTemplateCardViewHolder extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateCardViewHolderBinding binding;
    private final GuildTemplatesAdapter.Callbacks callbacks;

    /* compiled from: GuildTemplateViewHolders.kt */
    /* renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ GuildTemplate $guildTemplate;

        public AnonymousClass2(GuildTemplate guildTemplate) {
            this.$guildTemplate = guildTemplate;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildTemplateCardViewHolder.this.getCallbacks().onTemplateClick(this.$guildTemplate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateCardViewHolder(NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding, GuildTemplatesAdapter.Callbacks callbacks) {
        super(nuxGuildTemplateCardViewHolderBinding.a);
        m.checkNotNullParameter(nuxGuildTemplateCardViewHolderBinding, "binding");
        m.checkNotNullParameter(callbacks, "callbacks");
        this.binding = nuxGuildTemplateCardViewHolderBinding;
        this.callbacks = callbacks;
    }

    public final void bind(GuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        TextView textView = this.binding.c;
        textView.setText(guildTemplate.getTitleRes());
        DrawableCompat.setCompoundDrawablesCompat(textView, guildTemplate.getDrawableRes(), 0, R.drawable.icon_carrot, 0);
        this.binding.f2132b.setOnClickListener(new AnonymousClass2(guildTemplate));
    }

    public final NuxGuildTemplateCardViewHolderBinding getBinding() {
        return this.binding;
    }

    public final GuildTemplatesAdapter.Callbacks getCallbacks() {
        return this.callbacks;
    }
}

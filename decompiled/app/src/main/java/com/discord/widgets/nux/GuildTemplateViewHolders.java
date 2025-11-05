package com.discord.widgets.nux;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import d0.z.d.Intrinsics3;

/* compiled from: GuildTemplateViewHolders.kt */
/* renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildTemplateViewHolders extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateCardViewHolderBinding binding;
    private final GuildTemplatesAdapter.Callbacks callbacks;

    /* compiled from: GuildTemplateViewHolders.kt */
    /* renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ GuildTemplates $guildTemplate;

        public AnonymousClass2(GuildTemplates guildTemplates) {
            this.$guildTemplate = guildTemplates;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildTemplateViewHolders.this.getCallbacks().onTemplateClick(this.$guildTemplate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateViewHolders(NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding, GuildTemplatesAdapter.Callbacks callbacks) {
        super(nuxGuildTemplateCardViewHolderBinding.a);
        Intrinsics3.checkNotNullParameter(nuxGuildTemplateCardViewHolderBinding, "binding");
        Intrinsics3.checkNotNullParameter(callbacks, "callbacks");
        this.binding = nuxGuildTemplateCardViewHolderBinding;
        this.callbacks = callbacks;
    }

    public final void bind(GuildTemplates guildTemplate) {
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
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

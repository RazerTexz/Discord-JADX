package com.discord.widgets.guilds.create;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import b.a.i.r0;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* compiled from: GuildCreateCloneViews.kt */
/* loaded from: classes2.dex */
public interface GuildCreateCloneViews {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: GuildCreateCloneViews.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final GuildCreateCloneViews from(WidgetGuildCreateBinding binding) {
            m.checkNotNullParameter(binding, "binding");
            return new GuildCreateViews(binding);
        }

        public final GuildCreateCloneViews from(WidgetGuildCloneBinding binding) {
            m.checkNotNullParameter(binding, "binding");
            return new GuildCloneViews(binding);
        }
    }

    /* compiled from: GuildCreateCloneViews.kt */
    public static final class GuildCloneViews implements GuildCreateCloneViews {
        private final TextView guidelinesTextView;
        private final LoadingButton guildCreateButton;
        private final ViewGroup guildCreateIconUploader;
        private final TextInputLayout guildCreateName;
        private final SimpleDraweeView iconUploaderImage;
        private final Group iconUploaderPlaceholderGroup;
        private final ScreenTitleView screenTitleView;

        public GuildCloneViews(WidgetGuildCloneBinding widgetGuildCloneBinding) {
            m.checkNotNullParameter(widgetGuildCloneBinding, "binding");
            LoadingButton loadingButton = widgetGuildCloneBinding.f2410b;
            m.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCloneBinding.f;
            m.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCloneBinding.e.f190b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCloneBinding.e.c;
            m.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            r0 r0Var = widgetGuildCloneBinding.e;
            m.checkNotNullExpressionValue(r0Var, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = r0Var.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCloneBinding.d;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextView getGuidelinesTextView() {
            return this.guidelinesTextView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public LoadingButton getGuildCreateButton() {
            return this.guildCreateButton;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ViewGroup getGuildCreateIconUploader() {
            return this.guildCreateIconUploader;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextInputLayout getGuildCreateName() {
            return this.guildCreateName;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public SimpleDraweeView getIconUploaderImage() {
            return this.iconUploaderImage;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public Group getIconUploaderPlaceholderGroup() {
            return this.iconUploaderPlaceholderGroup;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ScreenTitleView getScreenTitleView() {
            return this.screenTitleView;
        }
    }

    /* compiled from: GuildCreateCloneViews.kt */
    public static final class GuildCreateViews implements GuildCreateCloneViews {
        private final TextView guidelinesTextView;
        private final LoadingButton guildCreateButton;
        private final ViewGroup guildCreateIconUploader;
        private final TextInputLayout guildCreateName;
        private final SimpleDraweeView iconUploaderImage;
        private final Group iconUploaderPlaceholderGroup;
        private final ScreenTitleView screenTitleView;

        public GuildCreateViews(WidgetGuildCreateBinding widgetGuildCreateBinding) {
            m.checkNotNullParameter(widgetGuildCreateBinding, "binding");
            LoadingButton loadingButton = widgetGuildCreateBinding.f2412b;
            m.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCreateBinding.e;
            m.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCreateBinding.d.f190b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCreateBinding.d.c;
            m.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            r0 r0Var = widgetGuildCreateBinding.d;
            m.checkNotNullExpressionValue(r0Var, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = r0Var.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCreateBinding.c;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
            ScreenTitleView screenTitleView = widgetGuildCreateBinding.f;
            m.checkNotNullExpressionValue(screenTitleView, "binding.guildCreateScreenTitle");
            this.screenTitleView = screenTitleView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextView getGuidelinesTextView() {
            return this.guidelinesTextView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public LoadingButton getGuildCreateButton() {
            return this.guildCreateButton;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ViewGroup getGuildCreateIconUploader() {
            return this.guildCreateIconUploader;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextInputLayout getGuildCreateName() {
            return this.guildCreateName;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public SimpleDraweeView getIconUploaderImage() {
            return this.iconUploaderImage;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public Group getIconUploaderPlaceholderGroup() {
            return this.iconUploaderPlaceholderGroup;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ScreenTitleView getScreenTitleView() {
            return this.screenTitleView;
        }
    }

    TextView getGuidelinesTextView();

    LoadingButton getGuildCreateButton();

    ViewGroup getGuildCreateIconUploader();

    TextInputLayout getGuildCreateName();

    SimpleDraweeView getIconUploaderImage();

    Group getIconUploaderPlaceholderGroup();

    ScreenTitleView getScreenTitleView();
}

package com.discord.widgets.guilds.create;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import p007b.p008a.p025i.LayoutIconUploaderBinding;
import p507d0.p592z.p594d.Intrinsics3;

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
            Intrinsics3.checkNotNullParameter(binding, "binding");
            return new GuildCreateViews(binding);
        }

        public final GuildCreateCloneViews from(WidgetGuildCloneBinding binding) {
            Intrinsics3.checkNotNullParameter(binding, "binding");
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
            Intrinsics3.checkNotNullParameter(widgetGuildCloneBinding, "binding");
            LoadingButton loadingButton = widgetGuildCloneBinding.f16752b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCloneBinding.f16756f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCloneBinding.f16755e.f1174b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCloneBinding.f16755e.f1175c;
            Intrinsics3.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            LayoutIconUploaderBinding layoutIconUploaderBinding = widgetGuildCloneBinding.f16755e;
            Intrinsics3.checkNotNullExpressionValue(layoutIconUploaderBinding, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = layoutIconUploaderBinding.f1173a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCloneBinding.f16754d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
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
            Intrinsics3.checkNotNullParameter(widgetGuildCreateBinding, "binding");
            LoadingButton loadingButton = widgetGuildCreateBinding.f16769b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCreateBinding.f16772e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCreateBinding.f16771d.f1174b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCreateBinding.f16771d.f1175c;
            Intrinsics3.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            LayoutIconUploaderBinding layoutIconUploaderBinding = widgetGuildCreateBinding.f16771d;
            Intrinsics3.checkNotNullExpressionValue(layoutIconUploaderBinding, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = layoutIconUploaderBinding.f1173a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCreateBinding.f16770c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
            ScreenTitleView screenTitleView = widgetGuildCreateBinding.f16773f;
            Intrinsics3.checkNotNullExpressionValue(screenTitleView, "binding.guildCreateScreenTitle");
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

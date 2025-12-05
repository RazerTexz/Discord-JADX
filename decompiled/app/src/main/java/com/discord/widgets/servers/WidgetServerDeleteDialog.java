package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func2;

/* compiled from: WidgetServerDeleteDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetServerDeleteDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerDeleteDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetServerDeleteDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetServerDeleteDialog widgetServerDeleteDialog = new WidgetServerDeleteDialog();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetServerDeleteDialog.INTENT_GUILD_ID, guildId);
            widgetServerDeleteDialog.setArguments(bundle);
            widgetServerDeleteDialog.show(fragmentManager, WidgetServerDeleteDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final MeUser me;

        /* compiled from: WidgetServerDeleteDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get$app_productionGoogleRelease(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
                WidgetServerDeleteDialog2 widgetServerDeleteDialog2 = WidgetServerDeleteDialog2.INSTANCE;
                Object widgetServerDeleteDialog4 = widgetServerDeleteDialog2;
                if (widgetServerDeleteDialog2 != null) {
                    widgetServerDeleteDialog4 = new WidgetServerDeleteDialog4(widgetServerDeleteDialog2);
                }
                Observable observableM11076j = Observable.m11076j(observableObserveMe$default, observableObserveGuild, (Func2) widgetServerDeleteDialog4);
                Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…      ::Model\n          )");
                return ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.guild = guild;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MeUser getMe() {
            return this.me;
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$1 */
    public static final class ViewOnClickListenerC91541 implements View.OnClickListener {
        public ViewOnClickListenerC91541() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerDeleteDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$2 */
    public static final class ViewOnClickListenerC91552 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        /* compiled from: WidgetServerDeleteDialog.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Void> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r4) {
                ViewOnClickListenerC91552 viewOnClickListenerC91552 = ViewOnClickListenerC91552.this;
                WidgetServerDeleteDialog.access$afterDeleteGuild(WidgetServerDeleteDialog.this, viewOnClickListenerC91552.$this_configureUI.getGuild().getId());
            }
        }

        public ViewOnClickListenerC91552(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            long id2 = this.$this_configureUI.getGuild().getId();
            TextInputLayout textInputLayout = WidgetServerDeleteDialog.access$getBinding$p(WidgetServerDeleteDialog.this).f17483e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsDeleteServerMfaCode");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.deleteGuild(id2, new RestAPIParams.DeleteGuild(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), WidgetServerDeleteDialog.this, null, 2, null).m11108k(C0879o.m183j(new AnonymousClass1(), WidgetServerDeleteDialog.this.getContext(), null, 4));
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$onViewBoundOrOnResume$1 */
    public static final class C91561 extends Lambda implements Function1<Model, Unit> {
        public C91561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerDeleteDialog widgetServerDeleteDialog = WidgetServerDeleteDialog.this;
            Intrinsics3.checkNotNullExpressionValue(model, "it");
            WidgetServerDeleteDialog.access$configureUI(widgetServerDeleteDialog, model);
        }
    }

    public WidgetServerDeleteDialog() {
        super(C5419R.layout.widget_server_delete_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerDeleteDialog3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$afterDeleteGuild(WidgetServerDeleteDialog widgetServerDeleteDialog, long j) {
        widgetServerDeleteDialog.afterDeleteGuild(j);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerDeleteDialog widgetServerDeleteDialog, Model model) {
        widgetServerDeleteDialog.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerDeleteDialogBinding access$getBinding$p(WidgetServerDeleteDialog widgetServerDeleteDialog) {
        return widgetServerDeleteDialog.getBinding();
    }

    private final void afterDeleteGuild(long guildId) {
        dismiss();
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2020-12_guild_delete_feedback", true);
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            return;
        }
        GuildDeleteFeedbackSheetNavigator.INSTANCE.enqueueNotice(guildId);
    }

    private final void configureUI(Model model) {
        if (model.getGuild() == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().f17482d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsDeleteServerHeader");
        Context context = getContext();
        textView.setText(context != null ? FormatUtils.m216h(context, C5419R.string.delete_server_title, new Object[]{model.getGuild().getName()}, null, 4) : null);
        LinearLayout linearLayout = getBinding().f17484f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsDeleteServerMfaWrap");
        linearLayout.setVisibility(model.getMe().getMfaEnabled() ? 0 : 8);
        TextView textView2 = getBinding().f17485g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsDeleteServerText");
        FormatUtils.m222n(textView2, C5419R.string.delete_server_body, new Object[]{model.getGuild().getName()}, null, 4);
        getBinding().f17480b.setOnClickListener(new ViewOnClickListenerC91541());
        MaterialButton materialButton = getBinding().f17481c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsDeleteServerConfirm");
        materialButton.setEnabled(model.getGuild().isOwner(model.getMe().getId()));
        getBinding().f17481c.setOnClickListener(new ViewOnClickListenerC91552(model));
    }

    private final WidgetServerDeleteDialogBinding getBinding() {
        return (WidgetServerDeleteDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observable = Model.INSTANCE.get$app_productionGoogleRelease(getArgumentsOrDefault().getLong(INTENT_GUILD_ID));
        Intrinsics3.checkNotNullExpressionValue(observable, "Model.get(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetServerDeleteDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91561(), 62, (Object) null);
    }
}

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
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/* compiled from: WidgetServerDeleteDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetServerDeleteDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerDeleteDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0)};

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
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
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
                WidgetServerDeleteDialog$Model$Companion$get$1 widgetServerDeleteDialog$Model$Companion$get$1 = WidgetServerDeleteDialog$Model$Companion$get$1.INSTANCE;
                Object widgetServerDeleteDialog$sam$rx_functions_Func2$0 = widgetServerDeleteDialog$Model$Companion$get$1;
                if (widgetServerDeleteDialog$Model$Companion$get$1 != null) {
                    widgetServerDeleteDialog$sam$rx_functions_Func2$0 = new WidgetServerDeleteDialog$sam$rx_functions_Func2$0(widgetServerDeleteDialog$Model$Companion$get$1);
                }
                Observable observableJ = Observable.j(observableObserveMe$default, observableObserveGuild, (Func2) widgetServerDeleteDialog$sam$rx_functions_Func2$0);
                m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      ::Model\n          )");
                return ObservableExtensionsKt.computationLatest(observableJ).r();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild) {
            m.checkNotNullParameter(meUser, "me");
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
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerDeleteDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        /* compiled from: WidgetServerDeleteDialog.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Void> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r4) {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                WidgetServerDeleteDialog.access$afterDeleteGuild(WidgetServerDeleteDialog.this, anonymousClass2.$this_configureUI.getGuild().getId());
            }
        }

        public AnonymousClass2(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            long id2 = this.$this_configureUI.getGuild().getId();
            TextInputLayout textInputLayout = WidgetServerDeleteDialog.access$getBinding$p(WidgetServerDeleteDialog.this).e;
            m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsDeleteServerMfaCode");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.deleteGuild(id2, new RestAPIParams.DeleteGuild(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), WidgetServerDeleteDialog.this, null, 2, null).k(o.j(new AnonymousClass1(), WidgetServerDeleteDialog.this.getContext(), null, 4));
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerDeleteDialog widgetServerDeleteDialog = WidgetServerDeleteDialog.this;
            m.checkNotNullExpressionValue(model, "it");
            WidgetServerDeleteDialog.access$configureUI(widgetServerDeleteDialog, model);
        }
    }

    public WidgetServerDeleteDialog() {
        super(R.layout.widget_server_delete_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerDeleteDialog$binding$2.INSTANCE, null, 2, null);
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
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsDeleteServerHeader");
        Context context = getContext();
        textView.setText(context != null ? b.h(context, R.string.delete_server_title, new Object[]{model.getGuild().getName()}, null, 4) : null);
        LinearLayout linearLayout = getBinding().f;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsDeleteServerMfaWrap");
        linearLayout.setVisibility(model.getMe().getMfaEnabled() ? 0 : 8);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsDeleteServerText");
        b.n(textView2, R.string.delete_server_body, new Object[]{model.getGuild().getName()}, null, 4);
        getBinding().f2536b.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsDeleteServerConfirm");
        materialButton.setEnabled(model.getGuild().isOwner(model.getMe().getId()));
        getBinding().c.setOnClickListener(new AnonymousClass2(model));
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
        m.checkNotNullExpressionValue(observable, "Model.get(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetServerDeleteDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

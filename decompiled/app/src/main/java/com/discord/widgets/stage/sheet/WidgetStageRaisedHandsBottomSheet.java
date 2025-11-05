package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import d0.g;
import d0.o;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageRaisedHandsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private boolean hasReceivedInitialRaisedHandsState;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetStageRaisedHandsBottomSheet show(FragmentManager fragmentManager, long channelId) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet = new WidgetStageRaisedHandsBottomSheet();
            widgetStageRaisedHandsBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageRaisedHandsBottomSheet.show(fragmentManager, WidgetStageRaisedHandsBottomSheet.class.getSimpleName());
            return widgetStageRaisedHandsBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04651 extends d0.z.d.o implements Function0<Unit> {
            public C04651() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b.a.d.m.g(WidgetStageRaisedHandsBottomSheet.this.getContext(), R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends d0.z.d.o implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(WidgetStageRaisedHandsBottomSheet.this).setSpeakingState(false);
            }
        }

        public AnonymousClass1(WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean zIsSpeaker = this.$viewState.isSpeaker();
            if (zIsSpeaker) {
                WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(WidgetStageRaisedHandsBottomSheet.this).setSpeakingState(true);
            } else {
                if (zIsSpeaker) {
                    return;
                }
                WidgetStageRaisedHandsBottomSheet.this.requestMicrophone(new C04651(), new AnonymousClass2());
            }
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetStageRaisedHandsBottomSheet.access$configureUI(WidgetStageRaisedHandsBottomSheet.this, viewState);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            m.checkNotNullParameter(event, "event");
            WidgetStageRaisedHandsBottomSheet.access$handleEvent(WidgetStageRaisedHandsBottomSheet.this, event);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            m.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(WidgetStageRaisedHandsBottomSheet.access$getChannelId$p(WidgetStageRaisedHandsBottomSheet.this));
            FragmentManager parentFragmentManager = WidgetStageRaisedHandsBottomSheet.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, parentFragmentManager, null, null, null, null, 120, null);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass3(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "dismissRequestToSpeak", "dismissRequestToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            m.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).dismissRequestToSpeak(voiceUser);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass4(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "inviteToSpeak", "inviteToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            m.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).inviteToSpeak(voiceUser);
        }
    }

    public WidgetStageRaisedHandsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageRaisedHandsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.adapter = g.lazy(new WidgetStageRaisedHandsBottomSheet$adapter$2(this));
        this.channelId = g.lazy(new WidgetStageRaisedHandsBottomSheet$channelId$2(this));
        WidgetStageRaisedHandsBottomSheet$viewModel$2 widgetStageRaisedHandsBottomSheet$viewModel$2 = new WidgetStageRaisedHandsBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetStageRaisedHandsBottomSheetViewModel.class), new WidgetStageRaisedHandsBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStageRaisedHandsBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        widgetStageRaisedHandsBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetBinding access$getBinding$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel access$getViewModel$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
        widgetStageRaisedHandsBottomSheet.handleEvent(event);
    }

    private final void configureToggleSpeakerState(WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded viewState) {
        String string;
        int i;
        getBinding().g.setOnClickListener(new AnonymousClass1(viewState));
        MaterialTextView materialTextView = getBinding().g;
        m.checkNotNullExpressionValue(materialTextView, "binding.toggleSpeakerStateButton");
        boolean zIsSpeaker = viewState.isSpeaker();
        if (zIsSpeaker) {
            string = getString(R.string.move_me_to_audience);
        } else {
            if (zIsSpeaker) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(R.string.moderator_raise_own_hand);
        }
        materialTextView.setText(string);
        ImageView imageView = getBinding().h;
        boolean zIsSpeaker2 = viewState.isSpeaker();
        if (zIsSpeaker2) {
            i = R.drawable.ic_stage_move_to_audience;
        } else {
            if (zIsSpeaker2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.drawable.ic_stage_move_to_speaker;
        }
        imageView.setImageResource(i);
    }

    private final void configureUI(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) {
            WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded loaded = (WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) viewState;
            getBinding().f.setText(loaded.isRequestToSpeakEnabled() ? R.string.request_to_speak_area_all_roles : R.string.request_to_speak_area_all_roles_disabled);
            SwitchMaterial switchMaterial = getBinding().d;
            switchMaterial.setEnabled(!loaded.isUpdatingRequestToSpeakPermissions());
            if (!loaded.isUpdatingRequestToSpeakPermissions()) {
                ViewExtensions.setProgrammaticChecked(switchMaterial, loaded.isRequestToSpeakEnabled(), new WidgetStageRaisedHandsBottomSheet$configureUI$$inlined$apply$lambda$1(this, viewState));
            }
            if (!this.hasReceivedInitialRaisedHandsState) {
                this.hasReceivedInitialRaisedHandsState = true;
                switchMaterial.jumpDrawablesToCurrentState();
            }
            Group group = getBinding().c;
            m.checkNotNullExpressionValue(group, "binding.raisedHandsEmptyGroup");
            group.setVisibility(loaded.getIsEmpty() ? 0 : 8);
            MaterialTextView materialTextView = getBinding().f2657b;
            m.checkNotNullExpressionValue(materialTextView, "binding.raisedHandsCountLabel");
            b.n(materialTextView, R.string.request_to_speak_list_title, new Object[]{Integer.valueOf(loaded.getRaisedHandsParticipants().size())}, null, 4);
            configureToggleSpeakerState(loaded);
            getAdapter().setData(loaded.getRaisedHandsParticipants());
        }
    }

    private final WidgetStageRaisedHandsBottomSheetAdapter getAdapter() {
        return (WidgetStageRaisedHandsBottomSheetAdapter) this.adapter.getValue();
    }

    private final WidgetStageRaisedHandsBottomSheetBinding getBinding() {
        return (WidgetStageRaisedHandsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageRaisedHandsBottomSheetViewModel getViewModel() {
        return (WidgetStageRaisedHandsBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
        if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel.Event.Dismiss) {
            dismiss();
        } else if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel.Event.Error) {
            ((WidgetStageRaisedHandsBottomSheetViewModel.Event.Error) event).getError().showToasts(getContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_raised_hands_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageRaisedHandsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStageRaisedHandsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.hasReceivedInitialRaisedHandsState = false;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().e;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.widget_stage_raised_hands_divider);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        maxHeightRecyclerView.addItemDecoration(dividerItemDecoration);
        getAdapter().setOnViewProfile(new AnonymousClass2());
        getAdapter().setOnDismissRequest(new AnonymousClass3(getViewModel()));
        getAdapter().setOnInviteToSpeak(new AnonymousClass4(getViewModel()));
        MGRecyclerAdapter.INSTANCE.configure(getAdapter());
    }
}

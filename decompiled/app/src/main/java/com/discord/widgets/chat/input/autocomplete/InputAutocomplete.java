package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.i.c.m.d.k.h;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.LoadState;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputApplicationsAdapter;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter;
import com.discord.widgets.chat.input.WidgetChatInputEditText;
import com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandAdapter;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewState;
import com.discord.widgets.chat.input.autocomplete.Event;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState;
import com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.FlexInputAttachmentListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.t;
import d0.t.c0;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import rx.Observable;

/* compiled from: InputAutocomplete.kt */
/* loaded from: classes2.dex */
public final class InputAutocomplete {
    private final ChatInputAutocompleteAdapter autocompleteAdapter;
    private final TextView autocompleteHeader;
    private final RecyclerView autocompleteRecyclerView;
    private final ChatInputApplicationsAdapter categoriesAdapter;
    private final Long channel;
    private final RecyclerView commandBrowserAppsRecyclerView;
    private boolean commandBrowserOpen;
    private final FlexEditText editText;
    private final FlexInputFragment flexInputFragment;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment fragment;
    private Function1<? super ApplicationCommandOption, Unit> onPerformCommandAutocomplete;
    private final SelectedApplicationCommandAdapter selectedApplicationCommandAdapter;
    private final WidgetChatInputApplicationCommandsBinding selectedApplicationCommandUiBinding;
    private final TextView stickerHeader;
    private final WidgetChatInputAutocompleteStickerAdapter stickersAdapter;
    private final View stickersContainer;
    private final RecyclerView stickersRecyclerView;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FlexInputAttachmentListener {
        public AnonymousClass1() {
        }

        @Override // com.lytefast.flexinput.FlexInputAttachmentListener
        public void onAttachmentSelected(Attachment<?> attachment) {
            m.checkNotNullParameter(attachment, "attachment");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).setAttachment(attachment);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements TextWatcher {
        private int before;
        private int count;
        private int start;

        public AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s2) {
            m.checkNotNullParameter(s2, "s");
            InputAutocomplete.access$applyEditTextAction(InputAutocomplete.this, InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onInputTextChanged(s2, this.start, this.before, this.count));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        }

        public final int getBefore() {
            return this.before;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getStart() {
            return this.start;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s2, int start, int before, int count) {
            this.start = start;
            this.before = before;
            this.count = count;
        }

        public final void setBefore(int i) {
            this.before = i;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setStart(int i) {
            this.start = i;
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function2<Integer, Integer, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onSelectionChanged(InputAutocomplete.access$getEditText$p(InputAutocomplete.this).getEditableText().toString(), i, i2);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Application, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Application application) {
            invoke2(application);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Application application) {
            m.checkNotNullParameter(application, "it");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectCommandBrowserApplication(application);
            InputAutocomplete.access$getCategoriesAdapter$p(InputAutocomplete.this).selectApplication(application.getId());
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<Autocompletable, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Autocompletable autocompletable) {
            invoke2(autocompletable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Autocompletable autocompletable) {
            m.checkNotNullParameter(autocompletable, "it");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectAutocompleteItem(autocompletable);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$6, reason: invalid class name */
    public static final class AnonymousClass6 extends o implements Function1<Sticker, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            m.checkNotNullParameter(sticker, "sticker");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectStickerItem(sticker);
            Context context = InputAutocomplete.access$getEditText$p(InputAutocomplete.this).getContext();
            m.checkNotNullExpressionValue(context, "editText.context");
            MessageManager.sendMessage$default(new MessageManager(context, null, null, null, null, null, null, null, null, 510, null), null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$7, reason: invalid class name */
    public static final class AnonymousClass7 extends o implements Function1<ApplicationCommandOption, Unit> {
        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
            invoke2(applicationCommandOption);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandOption applicationCommandOption) {
            m.checkNotNullParameter(applicationCommandOption, "it");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectCommandOption(applicationCommandOption);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$configureAutocompleteBrowser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Integer, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            int iMin = Math.min(i2, InputAutocomplete.access$getAutocompleteAdapter$p(InputAutocomplete.this).getPageSize() - 1);
            if (i >= 0 && iMin >= i) {
                IntRange intRange = new IntRange(i, iMin);
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRange, 10));
                Iterator<Integer> it = intRange.iterator();
                while (it.hasNext()) {
                    arrayList.add(InputAutocomplete.access$getAutocompleteAdapter$p(InputAutocomplete.this).getItem(((c0) it).nextInt()));
                }
                InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).checkEmojiAutocompleteUpsellViewed(arrayList);
            }
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$configureCommandBrowser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Integer, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            Long lAccess$getCurrentlySelectedCategory;
            if (i >= 0 && (lAccess$getCurrentlySelectedCategory = InputAutocomplete.access$getCurrentlySelectedCategory(InputAutocomplete.this, i)) != null) {
                long jLongValue = lAccess$getCurrentlySelectedCategory.longValue();
                InputAutocomplete.access$getCategoriesAdapter$p(InputAutocomplete.this).selectApplication(jLongValue);
                int positionOfApplication = InputAutocomplete.access$getCategoriesAdapter$p(InputAutocomplete.this).getPositionOfApplication(jLongValue);
                if (positionOfApplication >= 0) {
                    InputAutocomplete.access$getCommandBrowserAppsRecyclerView$p(InputAutocomplete.this).smoothScrollToPosition(positionOfApplication);
                }
            }
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onCommandsBrowserScroll(i, i2, InputAutocomplete.access$getAutocompleteAdapter$p(InputAutocomplete.this).getPageSize());
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Event event) {
            super(0);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onAttachmentRemoved(((Event.PreviewAttachment) this.$event).getAttachment());
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Event event) {
            super(1);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((Event.PreviewAttachment) this.$event).getAttachment().setSpoiler(z2);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            InputAutocomplete.access$getFragment$p(InputAutocomplete.this).showKeyboard(InputAutocomplete.access$getEditText$p(InputAutocomplete.this));
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<ViewState, Unit> {
        public AnonymousClass1(InputAutocomplete inputAutocomplete) {
            super(1, inputAutocomplete, InputAutocomplete.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/autocomplete/ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            InputAutocomplete.access$configureUI((InputAutocomplete) this.receiver, viewState);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<InputEditTextAction, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InputEditTextAction inputEditTextAction) {
            invoke2(inputEditTextAction);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InputEditTextAction inputEditTextAction) {
            InputAutocomplete inputAutocomplete = InputAutocomplete.this;
            m.checkNotNullExpressionValue(inputEditTextAction, "it");
            InputAutocomplete.access$applyEditTextAction(inputAutocomplete, inputEditTextAction);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<Event, Unit> {
        public AnonymousClass3(InputAutocomplete inputAutocomplete) {
            super(1, inputAutocomplete, InputAutocomplete.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/autocomplete/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event event) {
            m.checkNotNullParameter(event, "p1");
            InputAutocomplete.access$handleEvent((InputAutocomplete) this.receiver, event);
        }
    }

    public InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding) {
        m.checkNotNullParameter(appFragment, "fragment");
        m.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        m.checkNotNullParameter(flexEditText, "editText");
        m.checkNotNullParameter(textView, "autocompleteHeader");
        m.checkNotNullParameter(recyclerView, "autocompleteRecyclerView");
        m.checkNotNullParameter(recyclerView2, "commandBrowserAppsRecyclerView");
        m.checkNotNullParameter(view, "stickersContainer");
        m.checkNotNullParameter(recyclerView3, "stickersRecyclerView");
        m.checkNotNullParameter(textView2, "stickerHeader");
        m.checkNotNullParameter(widgetChatInputApplicationCommandsBinding, "selectedApplicationCommandUiBinding");
        this.fragment = appFragment;
        this.flexInputFragment = flexInputFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.editText = flexEditText;
        this.channel = l;
        this.autocompleteHeader = textView;
        this.autocompleteRecyclerView = recyclerView;
        this.commandBrowserAppsRecyclerView = recyclerView2;
        this.stickersContainer = view;
        this.stickersRecyclerView = recyclerView3;
        this.stickerHeader = textView2;
        this.selectedApplicationCommandUiBinding = widgetChatInputApplicationCommandsBinding;
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = new ChatInputAutocompleteAdapter();
        this.autocompleteAdapter = chatInputAutocompleteAdapter;
        InputAutocomplete$viewModel$2 inputAutocomplete$viewModel$2 = new InputAutocomplete$viewModel$2(this);
        g0 g0Var = new g0(appFragment);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(appFragment, a0.getOrCreateKotlinClass(AutocompleteViewModel.class), new InputAutocomplete$appViewModels$$inlined$viewModels$1(g0Var), new i0(inputAutocomplete$viewModel$2));
        appFlexInputViewModel.setAttachmentSelectedListener(new AnonymousClass1());
        flexEditText.addTextChangedListener(new AnonymousClass2());
        flexEditText.setOnSelectionChangedListener(new AnonymousClass3());
        ChatInputApplicationsAdapter chatInputApplicationsAdapter = new ChatInputApplicationsAdapter();
        this.categoriesAdapter = chatInputApplicationsAdapter;
        chatInputApplicationsAdapter.setOnClickApplication(new AnonymousClass4());
        RecyclerView.LayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(recyclerView2, chatInputApplicationsAdapter, 0, false, 8, null);
        recyclerView2.setAdapter(chatInputApplicationsAdapter);
        recyclerView2.setLayoutManager(selfHealingLinearLayoutManager);
        recyclerView2.setItemAnimator(null);
        chatInputAutocompleteAdapter.setOnItemSelected(new AnonymousClass5());
        recyclerView.setAdapter(chatInputAutocompleteAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setBackgroundColor(ColorCompat.getThemedColor(flexEditText, R.attr.colorBackgroundSecondary));
        WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter = (WidgetChatInputAutocompleteStickerAdapter) MGRecyclerAdapter.INSTANCE.configure(new WidgetChatInputAutocompleteStickerAdapter(recyclerView3, new AnonymousClass6()));
        this.stickersAdapter = widgetChatInputAutocompleteStickerAdapter;
        recyclerView3.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView3, widgetChatInputAutocompleteStickerAdapter, 0, false, 8, null));
        recyclerView3.setAdapter(widgetChatInputAutocompleteStickerAdapter);
        RecyclerView recyclerView4 = widgetChatInputApplicationCommandsBinding.c;
        m.checkNotNullExpressionValue(recyclerView4, "selectedApplicationComma…plicationCommandsRecycler");
        SelectedApplicationCommandAdapter selectedApplicationCommandAdapter = new SelectedApplicationCommandAdapter(recyclerView4, new AnonymousClass7());
        this.selectedApplicationCommandAdapter = selectedApplicationCommandAdapter;
        selectedApplicationCommandAdapter.getRecycler().setLayoutManager(new SelfHealingLinearLayoutManager(selectedApplicationCommandAdapter.getRecycler(), selectedApplicationCommandAdapter, 0, false, 8, null));
        selectedApplicationCommandAdapter.getRecycler().setAdapter(selectedApplicationCommandAdapter);
        selectedApplicationCommandAdapter.getRecycler().setItemAnimator(null);
    }

    public static final /* synthetic */ void access$applyEditTextAction(InputAutocomplete inputAutocomplete, InputEditTextAction inputEditTextAction) {
        inputAutocomplete.applyEditTextAction(inputEditTextAction);
    }

    public static final /* synthetic */ void access$configureUI(InputAutocomplete inputAutocomplete, ViewState viewState) {
        inputAutocomplete.configureUI(viewState);
    }

    public static final /* synthetic */ ChatInputAutocompleteAdapter access$getAutocompleteAdapter$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.autocompleteAdapter;
    }

    public static final /* synthetic */ ChatInputApplicationsAdapter access$getCategoriesAdapter$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.categoriesAdapter;
    }

    public static final /* synthetic */ Long access$getChannel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.channel;
    }

    public static final /* synthetic */ RecyclerView access$getCommandBrowserAppsRecyclerView$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.commandBrowserAppsRecyclerView;
    }

    public static final /* synthetic */ Long access$getCurrentlySelectedCategory(InputAutocomplete inputAutocomplete, int i) {
        return inputAutocomplete.getCurrentlySelectedCategory(i);
    }

    public static final /* synthetic */ FlexEditText access$getEditText$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.editText;
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.flexInputViewModel;
    }

    public static final /* synthetic */ AppFragment access$getFragment$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.fragment;
    }

    public static final /* synthetic */ AutocompleteViewModel access$getViewModel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(InputAutocomplete inputAutocomplete, Event event) {
        inputAutocomplete.handleEvent(event);
    }

    private final void applyEditTextAction(InputEditTextAction action) {
        if (!m.areEqual(this.editText.getEditableText().toString(), action.getAssumedInput().toString())) {
            return;
        }
        if (action instanceof InputEditTextAction.ClearSpans) {
            Editable editableText = this.editText.getEditableText();
            m.checkNotNullExpressionValue(editableText, "editText.editableText");
            removeSpans$default(this, editableText, null, 2, null);
            Editable editableText2 = this.editText.getEditableText();
            m.checkNotNullExpressionValue(editableText2, "editText.editableText");
            removePillSpans(editableText2);
            return;
        }
        if (action instanceof InputEditTextAction.ReplaceCharacterStyleSpans) {
            Editable editableText3 = this.editText.getEditableText();
            m.checkNotNullExpressionValue(editableText3, "editText.editableText");
            removeSpans$default(this, editableText3, null, 2, null);
            for (Map.Entry<IntRange, List<CharacterStyle>> entry : ((InputEditTextAction.ReplaceCharacterStyleSpans) action).getSpans().entrySet()) {
                IntRange key = entry.getKey();
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    this.editText.getEditableText().setSpan((CharacterStyle) it.next(), key.getFirst(), key.getLast(), 33);
                }
            }
            return;
        }
        if (action instanceof InputEditTextAction.InsertText) {
            InputEditTextAction.InsertText insertText = (InputEditTextAction.InsertText) action;
            this.editText.getEditableText().replace(insertText.getInsertRange().getFirst(), insertText.getInsertRange().getLast(), insertText.getToAppend());
            this.editText.setSelection(Math.min(insertText.getSelectionIndex(), this.editText.getEditableText().length()));
            return;
        }
        if (action instanceof InputEditTextAction.RemoveText) {
            InputEditTextAction.RemoveText removeText = (InputEditTextAction.RemoveText) action;
            this.editText.getEditableText().replace(removeText.getRange().getFirst(), removeText.getRange().getLast(), "");
            this.editText.setSelection(removeText.getSelectionIndex());
            return;
        }
        if (!(action instanceof InputEditTextAction.ReplacePillSpans)) {
            if (action instanceof InputEditTextAction.SelectText) {
                InputEditTextAction.SelectText selectText = (InputEditTextAction.SelectText) action;
                this.editText.setSelection(selectText.getSelection().getFirst(), selectText.getSelection().getLast());
                return;
            } else {
                if (!(action instanceof InputEditTextAction.ReplaceText)) {
                    boolean z2 = action instanceof InputEditTextAction.None;
                    return;
                }
                InputEditTextAction.ReplaceText replaceText = (InputEditTextAction.ReplaceText) action;
                this.editText.setText(replaceText.getNewText());
                this.editText.setSelection(replaceText.getSelectionIndex());
                return;
            }
        }
        Editable editableText4 = this.editText.getEditableText();
        m.checkNotNullExpressionValue(editableText4, "editText.editableText");
        removePillSpans(editableText4);
        for (Map.Entry<IntRange, List<CharacterStyle>> entry2 : ((InputEditTextAction.ReplacePillSpans) action).getSpans().entrySet()) {
            IntRange key2 = entry2.getKey();
            Iterator<T> it2 = entry2.getValue().iterator();
            while (it2.hasNext()) {
                this.editText.getEditableText().setSpan((CharacterStyle) it2.next(), key2.getFirst(), key2.getLast(), 33);
            }
        }
    }

    private final void configureAutocomplete(AutocompleteViewState autocompleteViewState) {
        if (autocompleteViewState instanceof AutocompleteViewState.Autocomplete) {
            configureAutocompleteBrowser((AutocompleteViewState.Autocomplete) autocompleteViewState);
        } else if (autocompleteViewState instanceof AutocompleteViewState.CommandBrowser) {
            configureCommandBrowser((AutocompleteViewState.CommandBrowser) autocompleteViewState);
        } else if (m.areEqual(autocompleteViewState, AutocompleteViewState.Hidden.INSTANCE)) {
            hideAutocomplete();
        }
        if (!(autocompleteViewState instanceof AutocompleteViewState.CommandBrowser)) {
            this.commandBrowserOpen = false;
        }
        StoreStream.INSTANCE.getAutocomplete().setAutocompleteVisible(!(autocompleteViewState instanceof AutocompleteViewState.Hidden));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureAutocompleteBrowser(AutocompleteViewState.Autocomplete autocomplete) {
        List<Autocompletable> autocompletables;
        boolean z2 = !autocomplete.getStickers().isEmpty();
        if (!(this.autocompleteRecyclerView.getVisibility() == 0)) {
            this.autocompleteRecyclerView.setVisibility(0);
        }
        if (this.commandBrowserAppsRecyclerView.getVisibility() == 0) {
            this.commandBrowserAppsRecyclerView.setVisibility(8);
        }
        if (t.startsWith$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), false, 2, null) && (!autocomplete.getAutocompletables().isEmpty())) {
            this.autocompleteHeader.setVisibility(0);
            TextView textView = this.autocompleteHeader;
            textView.setText(b.j(textView, R.string.emoji_matching, new Object[]{autocomplete.getToken()}, null, 4));
        } else {
            this.autocompleteHeader.setVisibility(8);
        }
        this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, R.attr.colorTextNormal));
        if (autocomplete.isAutocomplete()) {
            this.autocompleteHeader.setVisibility(t.isBlank(autocomplete.getToken()) ^ true ? 0 : 8);
            if (autocomplete.isError()) {
                TextView textView2 = this.autocompleteHeader;
                textView2.setText(b.j(textView2, R.string.application_command_autocomplete_failed, new Object[0], null, 4));
                this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, R.attr.colorTextDanger));
            } else if (autocomplete.isLoading()) {
                TextView textView3 = this.autocompleteHeader;
                textView3.setText(b.j(textView3, R.string.options_matching, new Object[]{autocomplete.getToken()}, null, 4));
            } else {
                List<Autocompletable> autocompletables2 = autocomplete.getAutocompletables();
                if (autocompletables2 == null || autocompletables2.isEmpty()) {
                    TextView textView4 = this.autocompleteHeader;
                    textView4.setText(b.j(textView4, R.string.application_command_autocomplete_no_options, new Object[0], null, 4));
                }
            }
        }
        this.autocompleteAdapter.setVisiblePositionListener(new AnonymousClass1());
        getViewModel().onAutocompleteItemsUpdated();
        if (!autocomplete.isLoading() || autocomplete.isError()) {
            autocompletables = autocomplete.getAutocompletables();
        } else {
            autocompletables = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                autocompletables.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        ChatInputAutocompleteAdapter.setData$default(this.autocompleteAdapter, autocompletables, z2, false, 4, null);
        this.stickersRecyclerView.setVisibility(z2 ? 0 : 8);
        this.stickersContainer.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView5 = this.stickerHeader;
            textView5.setText(b.j(textView5, R.string.stickers_matching, new Object[]{t.replace$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), "", false, 4, (Object) null)}, null, 4));
            this.stickersAdapter.setData(autocomplete.getStickers());
        }
    }

    private final void configureCommandBrowser(AutocompleteViewState.CommandBrowser browser) {
        this.autocompleteHeader.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        List<Autocompletable> flattenCommandsModel = browser.getDiscoverCommands().getFlattenCommandsModel();
        boolean z2 = (flattenCommandsModel.isEmpty() ^ true) || browser.getDiscoverCommands().getLoadState().isLoading();
        if (!this.commandBrowserOpen && z2) {
            this.commandBrowserOpen = true;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getAnalytics().trackApplicationCommandBrowserOpened(companion.getChannelsSelected().getId());
        }
        if ((this.autocompleteRecyclerView.getVisibility() == 0) != z2) {
            this.autocompleteRecyclerView.setVisibility(z2 ? 0 : 8);
        }
        boolean z3 = browser.getApplications().size() > 1;
        if ((this.commandBrowserAppsRecyclerView.getVisibility() == 0) != z3) {
            this.commandBrowserAppsRecyclerView.setVisibility(z3 ? 0 : 8);
            if (z3) {
                this.categoriesAdapter.selectApplication(0L);
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(0);
            }
        }
        this.categoriesAdapter.setApplicationData(browser.getApplications());
        this.autocompleteAdapter.setVisiblePositionListener(new AnonymousClass1());
        if (this.autocompleteAdapter.getPageSize() > 3 && (browser.getDiscoverCommands().getLoadState() instanceof LoadState.JustLoadedUp)) {
            RecyclerView recyclerView = this.autocompleteRecyclerView;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            View childAt = this.autocompleteRecyclerView.getChildAt(0);
            m.checkNotNullExpressionValue(childAt, "autocompleteRecyclerView.getChildAt(0)");
            this.autocompleteAdapter.scrollToPosition((flattenCommandsModel.size() - this.autocompleteAdapter.getPageSize()) + childAdapterPosition, childAt.getTop(), false);
        }
        if ((!flattenCommandsModel.isEmpty()) && this.autocompleteAdapter.getPageSize() == 4 && (this.autocompleteAdapter.getItem(0) instanceof ApplicationCommandLoadingPlaceholder) && (this.autocompleteAdapter.getItem(3) instanceof ApplicationCommandLoadingPlaceholder) && (flattenCommandsModel.get(0) instanceof ApplicationCommandLoadingPlaceholder)) {
            this.autocompleteAdapter.scrollToPosition(3, 0, false);
        }
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        if (browser.getDiscoverCommands().getLoadState() instanceof LoadState.Loading) {
            flattenCommandsModel = new ArrayList<>();
            int iCount = u.count(new IntRange(1, 4));
            for (int i = 0; i < iCount; i++) {
                flattenCommandsModel.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        chatInputAutocompleteAdapter.setData(flattenCommandsModel, false, browser.getDiscoverCommands().getLoadState() instanceof LoadState.Loading);
    }

    private final void configureSelectedCommand(SelectedCommandViewState selectedCommandViewState) {
        if (m.areEqual(selectedCommandViewState, SelectedCommandViewState.Hidden.INSTANCE)) {
            hideSelectedCommand();
        } else if (selectedCommandViewState instanceof SelectedCommandViewState.SelectedCommand) {
            configureSelectedCommand((SelectedCommandViewState.SelectedCommand) selectedCommandViewState);
        }
    }

    private final void configureUI(ViewState viewState) {
        configureAutocomplete(viewState.getAutocompleteViewState());
        configureSelectedCommand(viewState.getSelectedCommandViewState());
    }

    public static /* synthetic */ ApplicationCommandData getApplicationCommandData$default(InputAutocomplete inputAutocomplete, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = null;
        }
        return inputAutocomplete.getApplicationCommandData(applicationCommandOption);
    }

    private final Long getCurrentlySelectedCategory(int topPosition) {
        Application application;
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        Integer headerPositionForItem = chatInputAutocompleteAdapter.getHeaderPositionForItem(topPosition);
        Autocompletable item = chatInputAutocompleteAdapter.getItem(headerPositionForItem != null ? headerPositionForItem.intValue() : 0);
        if (!(item instanceof ApplicationPlaceholder)) {
            item = null;
        }
        ApplicationPlaceholder applicationPlaceholder = (ApplicationPlaceholder) item;
        if (applicationPlaceholder == null || (application = applicationPlaceholder.getApplication()) == null) {
            return null;
        }
        return Long.valueOf(application.getId());
    }

    private final AutocompleteViewModel getViewModel() {
        return (AutocompleteViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleEvent(Event event) {
        if (event instanceof Event.ScrollAutocompletablesToApplication) {
            Event.ScrollAutocompletablesToApplication scrollAutocompletablesToApplication = (Event.ScrollAutocompletablesToApplication) event;
            ChatInputAutocompleteAdapter.scrollToPosition$default(this.autocompleteAdapter, scrollAutocompletablesToApplication.getTargetPosition(), 0, false, 6, null);
            this.categoriesAdapter.selectApplication(scrollAutocompletablesToApplication.getApplicationId());
            if (this.categoriesAdapter.getPositionOfApplication(scrollAutocompletablesToApplication.getApplicationId()) != -1) {
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(this.categoriesAdapter.getPositionOfApplication(scrollAutocompletablesToApplication.getApplicationId()));
                return;
            }
            return;
        }
        if (event instanceof Event.RequestAutocompleteData) {
            Function1<? super ApplicationCommandOption, Unit> function1 = this.onPerformCommandAutocomplete;
            if (function1 != null) {
                function1.invoke(((Event.RequestAutocompleteData) event).getOption());
                return;
            }
            return;
        }
        if (event instanceof Event.PickAttachment) {
            this.flexInputViewModel.onGalleryButtonClicked();
            return;
        }
        if (event instanceof Event.PreviewAttachment) {
            h.r(this.flexInputFragment.requireContext(), this.flexInputFragment.l());
            AttachmentBottomSheet.Companion companion = AttachmentBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = this.flexInputFragment.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
            Attachment<?> attachment = ((Event.PreviewAttachment) event).getAttachment();
            Objects.requireNonNull(attachment, "null cannot be cast to non-null type com.lytefast.flexinput.model.Attachment<kotlin.Any>");
            companion.show(childFragmentManager, attachment, new AnonymousClass1(event), new AnonymousClass2(event), new AnonymousClass3());
        }
    }

    private final void hideAutocomplete() {
        this.autocompleteRecyclerView.setVisibility(8);
        this.commandBrowserAppsRecyclerView.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        this.autocompleteHeader.setVisibility(8);
    }

    private final void hideSelectedCommand() {
        this.flexInputViewModel.setModeSingleSelect(false);
        this.flexInputViewModel.setAttachmentViewEnabled(true);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(8);
    }

    private final void removePillSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (obj instanceof SimpleRoundedBackgroundSpan) {
                spannable.removeSpan(obj);
            }
        }
    }

    private final void removeSpans(Spannable spannable, IntRange spanRange) {
        for (Object obj : spannable.getSpans(spanRange.getFirst(), spanRange.getLast(), Object.class)) {
            if ((obj instanceof CharacterStyle) && !(obj instanceof SimpleRoundedBackgroundSpan)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static /* synthetic */ void removeSpans$default(InputAutocomplete inputAutocomplete, Spannable spannable, IntRange intRange, int i, Object obj) {
        if ((i & 2) != 0) {
            intRange = new IntRange(0, spannable.length());
        }
        inputAutocomplete.removeSpans(spannable, intRange);
    }

    public final ApplicationCommandData getApplicationCommandData(ApplicationCommandOption focusedOption) {
        return getViewModel().getApplicationSendData(focusedOption);
    }

    public final Map<ApplicationCommandOption, Attachment<?>> getCommandAttachments() {
        return getViewModel().getCommandAttachments();
    }

    public final MessageContent getInputContent() {
        WidgetChatInputEditText.Companion companion = WidgetChatInputEditText.INSTANCE;
        String stringSafe = companion.toStringSafe(this.editText);
        String stringSafe2 = companion.toStringSafe(this.editText);
        int length = stringSafe2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = m.compare(stringSafe2.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        String string = stringSafe2.subSequence(i, length + 1).toString();
        return !TextUtils.isEmpty(string) ? getViewModel().replaceAutocompletableDataWithServerValues(stringSafe) : new MessageContent(string, n.emptyList());
    }

    public final Function1<ApplicationCommandOption, Unit> getOnPerformCommandAutocomplete() {
        return this.onPerformCommandAutocomplete;
    }

    public final void onCommandInputsSendError() {
        getViewModel().onApplicationCommandSendError();
    }

    public final void onViewBoundOrOnResume() {
        this.autocompleteAdapter.configureSubscriptions(this.fragment);
        Observable<ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable<InputEditTextAction> observableR2 = getViewModel().observeEditTextActions().r();
        m.checkNotNullExpressionValue(observableR2, "viewModel.observeEditTex…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR2, this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this), 62, (Object) null);
    }

    public final void setOnPerformCommandAutocomplete(Function1<? super ApplicationCommandOption, Unit> function1) {
        this.onPerformCommandAutocomplete = function1;
    }

    private final void configureSelectedCommand(SelectedCommandViewState.SelectedCommand viewState) {
        this.flexInputViewModel.setModeSingleSelect(true);
        this.flexInputViewModel.setAttachmentViewEnabled(false);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(0);
        this.selectedApplicationCommandAdapter.clear();
        this.selectedApplicationCommandAdapter.setApplicationCommand(viewState.getSelectedCommand(), viewState.getSelectedApplication());
        ApplicationCommandOption selectedCommandOption = viewState.getSelectedCommandOption();
        if (selectedCommandOption != null) {
            if (viewState.getSelectedCommandOptionErrors().contains(selectedCommandOption)) {
                TextView textView = this.selectedApplicationCommandUiBinding.f2301b;
                m.checkNotNullExpressionValue(textView, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources = this.editText.getResources();
                m.checkNotNullExpressionValue(resources, "editText.resources");
                textView.setText(StoreApplicationCommandsKt.getErrorText(selectedCommandOption, resources));
                WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = this.selectedApplicationCommandUiBinding;
                TextView textView2 = widgetChatInputApplicationCommandsBinding.f2301b;
                ConstraintLayout constraintLayout2 = widgetChatInputApplicationCommandsBinding.a;
                m.checkNotNullExpressionValue(constraintLayout2, "selectedApplicationCommandUiBinding.root");
                textView2.setTextColor(ColorCompat.getColor(constraintLayout2.getContext(), R.color.status_red_500));
            } else {
                TextView textView3 = this.selectedApplicationCommandUiBinding.f2301b;
                m.checkNotNullExpressionValue(textView3, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources2 = this.editText.getResources();
                m.checkNotNullExpressionValue(resources2, "editText.resources");
                textView3.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommandOption, resources2));
                this.selectedApplicationCommandUiBinding.f2301b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), R.attr.colorTextNormal));
            }
            this.selectedApplicationCommandAdapter.highlightOption(selectedCommandOption);
        } else {
            TextView textView4 = this.selectedApplicationCommandUiBinding.f2301b;
            m.checkNotNullExpressionValue(textView4, "selectedApplicationComma…CommandsOptionDescription");
            ApplicationCommand selectedCommand = viewState.getSelectedCommand();
            Resources resources3 = this.editText.getResources();
            m.checkNotNullExpressionValue(resources3, "editText.resources");
            textView4.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommand, resources3));
            this.selectedApplicationCommandUiBinding.f2301b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), R.attr.colorTextNormal));
            this.selectedApplicationCommandAdapter.clearParamOptionHighlight();
        }
        this.selectedApplicationCommandAdapter.setVerified(viewState.getValidSelectedCommandOptions(), viewState.getSelectedCommandOptionErrors());
    }

    public /* synthetic */ InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFragment, flexInputFragment, appFlexInputViewModel, flexEditText, (i & 16) != 0 ? null : l, textView, recyclerView, recyclerView2, view, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
    }
}

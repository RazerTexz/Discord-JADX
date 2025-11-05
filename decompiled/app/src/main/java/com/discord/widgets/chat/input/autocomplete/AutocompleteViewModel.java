package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppLog;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.ApplicationSubCommand;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.User;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.AutocompleteStickerItem;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewState;
import com.discord.widgets.chat.input.autocomplete.Event;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState;
import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.AutocompleteApplicationCommands;
import com.discord.widgets.chat.input.models.AutocompleteInputModel;
import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputCommandContext;
import com.discord.widgets.chat.input.models.InputSelectionModel;
import com.discord.widgets.chat.input.models.InputSelectionModelKt;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.MentionToken;
import com.discord.widgets.chat.input.models.OptionRange;
import com.lytefast.flexinput.model.Attachment;
import d0.d0.f;
import d0.g0.s;
import d0.g0.w;
import d0.g0.y;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.o0;
import d0.t.t;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import f0.e0.c;
import j0.k.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: AutocompleteViewModel.kt */
/* loaded from: classes2.dex */
public final class AutocompleteViewModel extends d0<ViewState> {
    public static final String COMMAND_DISCOVER_TOKEN = "/";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_PLACEHOLDER_COUNT = 3;
    private final BehaviorSubject<AutocompleteInputSelectionModel> autocompleteInputSelectionModelSubject;
    private final Long channelId;
    private final Map<ApplicationCommandOption, Attachment<?>> commandAttachments;
    private final int commandOptionErrorColor;
    private final int defaultCommandOptionBackgroundColor;
    private final int defaultMentionColor;
    private final BehaviorSubject<InputEditTextAction> editTextAction;
    private final boolean emojiAutocompleteUpsellEnabled;
    private final BehaviorSubject<Event> events;
    private final AppFlexInputViewModel flexInputViewModel;
    private final BehaviorSubject<MentionInputModel> inputMentionModelSubject;
    private final BehaviorSubject<SelectionState> inputSelectionSubject;
    private InputState inputState;
    private AutocompleteInputSelectionModel lastAutocompleteInputSelectionModel;
    private InputSelectionModel lastChatInputModel;
    private int lastJumpedSequenceId;
    private boolean logEmojiAutocompleteUpsellViewed;
    private ApplicationCommandOption selectedOptionForAttachment;
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreExperiments storeExperiments;
    private StoreState storeState;

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Throwable> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Autocomplete Store Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$10, reason: invalid class name */
    public static final class AnonymousClass10<T> implements Action1<Pair<? extends ApplicationCommandOption, ? extends String>> {
        public AnonymousClass10() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Pair<? extends ApplicationCommandOption, ? extends String> pair) {
            call2((Pair<ApplicationCommandOption, String>) pair);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Pair<ApplicationCommandOption, String> pair) {
            AutocompleteViewModel.this.getStoreApplicationCommands().setAutocompleteLoading(pair.getFirst().getName(), pair.getSecond());
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$11, reason: invalid class name */
    public static final class AnonymousClass11 extends o implements Function1<Pair<? extends ApplicationCommandOption, ? extends String>, Unit> {
        public AnonymousClass11() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends ApplicationCommandOption, ? extends String> pair) {
            invoke2((Pair<ApplicationCommandOption, String>) pair);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<ApplicationCommandOption, String> pair) {
            AutocompleteViewModel.access$getEvents$p(AutocompleteViewModel.this).onNext(new Event.RequestAutocompleteData(pair.getFirst()));
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$12, reason: invalid class name */
    public static final class AnonymousClass12<T, R> implements b<AutocompleteInputSelectionModel, String> {
        public static final AnonymousClass12 INSTANCE = new AnonymousClass12();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ String call(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            return call2(autocompleteInputSelectionModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            MentionToken autocompleteToken = autocompleteInputSelectionModel.getAutocompleteToken();
            if (autocompleteToken != null) {
                return autocompleteToken.getToken();
            }
            return null;
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<StoreState, Unit> {
        public AnonymousClass2(AutocompleteViewModel autocompleteViewModel) {
            super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "p1");
            AutocompleteViewModel.access$handleStoreState((AutocompleteViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, R> implements Func2<SelectionState, MentionInputModel, InputSelectionModel> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ InputSelectionModel call(SelectionState selectionState, MentionInputModel mentionInputModel) {
            return call2(selectionState, mentionInputModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final InputSelectionModel call2(SelectionState selectionState, MentionInputModel mentionInputModel) {
            if (!m.areEqual(selectionState.getInput(), mentionInputModel.getInput().toString())) {
                return null;
            }
            AutocompleteViewModel autocompleteViewModel = AutocompleteViewModel.this;
            IntRange selection = selectionState.getSelection();
            m.checkNotNullExpressionValue(mentionInputModel, "inputModel");
            return AutocompleteViewModel.access$handleSelectionWithInputModel(autocompleteViewModel, selection, mentionInputModel);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Throwable> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Autocomplete Input Selection Model Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends k implements Function1<InputSelectionModel, Unit> {
        public AnonymousClass5(AutocompleteViewModel autocompleteViewModel) {
            super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleInputSelectionModel", "handleInputSelectionModel(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InputSelectionModel inputSelectionModel) throws IOException {
            invoke2(inputSelectionModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InputSelectionModel inputSelectionModel) throws IOException {
            m.checkNotNullParameter(inputSelectionModel, "p1");
            AutocompleteViewModel.access$handleInputSelectionModel((AutocompleteViewModel) this.receiver, inputSelectionModel);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$6, reason: invalid class name */
    public static final class AnonymousClass6<T> implements Action1<Throwable> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Full Autocomplete Model Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$7, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass7 extends k implements Function1<AutocompleteInputSelectionModel, Unit> {
        public AnonymousClass7(AutocompleteViewModel autocompleteViewModel) {
            super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleAutocompleteInputSelectionModel", "handleAutocompleteInputSelectionModel(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            invoke2(autocompleteInputSelectionModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            m.checkNotNullParameter(autocompleteInputSelectionModel, "p1");
            AutocompleteViewModel.access$handleAutocompleteInputSelectionModel((AutocompleteViewModel) this.receiver, autocompleteInputSelectionModel);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$8, reason: invalid class name */
    public static final class AnonymousClass8<T> implements Action1<Throwable> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger.e$default(AppLog.g, "Full Autocomplete Model Error", th, null, 4, null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$9, reason: invalid class name */
    public static final class AnonymousClass9<T, R> implements b<AutocompleteInputSelectionModel, Pair<? extends ApplicationCommandOption, ? extends String>> {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Pair<? extends ApplicationCommandOption, ? extends String> call(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            return call2(autocompleteInputSelectionModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Pair<ApplicationCommandOption, String> call2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
            ApplicationCommandOption selectedCommandOption;
            InputSelectionModel inputSelectionModel = autocompleteInputSelectionModel.getInputSelectionModel();
            if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
                inputSelectionModel = null;
            }
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
            if (commandInputSelectionModel == null || (selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption()) == null || !selectedCommandOption.getAutocomplete()) {
                return null;
            }
            CommandOptionValue commandOptionValue = commandInputSelectionModel.getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
            return new Pair<>(selectedCommandOption, String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, Long l, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
            return companion.observeStores(l, storeApplicationCommands, storeApplicationCommandFrecency);
        }

        private final Observable<StoreState> observeStores(Long inputChannelId, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandsFrecency) {
            Observable observableG;
            if (inputChannelId != null) {
                observableG = StoreStream.INSTANCE.getChannels().observeChannel(inputChannelId.longValue()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            } else {
                observableG = StoreStream.INSTANCE.getChannelsSelected().observeSelectedChannel().y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            }
            Observable<StoreState> observableY = observableG.Y(new AutocompleteViewModel$Companion$observeStores$1(storeApplicationCommands, storeApplicationCommandsFrecency));
            m.checkNotNullExpressionValue(observableY, "inputChannel.switchMap {…      )\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class InputState {
        private Map<Long, Integer> applicationsPosition;
        private final CharSequence currentInput;
        private final Map<IntRange, Autocompletable> inputAutocompleteMap;
        private final ApplicationCommand selectedCommand;
        private final ApplicationCommandOption showErrorForOption;

        public InputState() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InputState(CharSequence charSequence, ApplicationCommand applicationCommand, Map<Long, Integer> map, ApplicationCommandOption applicationCommandOption, Map<IntRange, ? extends Autocompletable> map2) {
            m.checkNotNullParameter(charSequence, "currentInput");
            m.checkNotNullParameter(map, "applicationsPosition");
            m.checkNotNullParameter(map2, "inputAutocompleteMap");
            this.currentInput = charSequence;
            this.selectedCommand = applicationCommand;
            this.applicationsPosition = map;
            this.showErrorForOption = applicationCommandOption;
            this.inputAutocompleteMap = map2;
        }

        public static /* synthetic */ InputState copy$default(InputState inputState, CharSequence charSequence, ApplicationCommand applicationCommand, Map map, ApplicationCommandOption applicationCommandOption, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = inputState.currentInput;
            }
            if ((i & 2) != 0) {
                applicationCommand = inputState.selectedCommand;
            }
            ApplicationCommand applicationCommand2 = applicationCommand;
            if ((i & 4) != 0) {
                map = inputState.applicationsPosition;
            }
            Map map3 = map;
            if ((i & 8) != 0) {
                applicationCommandOption = inputState.showErrorForOption;
            }
            ApplicationCommandOption applicationCommandOption2 = applicationCommandOption;
            if ((i & 16) != 0) {
                map2 = inputState.inputAutocompleteMap;
            }
            return inputState.copy(charSequence, applicationCommand2, map3, applicationCommandOption2, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getCurrentInput() {
            return this.currentInput;
        }

        /* renamed from: component2, reason: from getter */
        public final ApplicationCommand getSelectedCommand() {
            return this.selectedCommand;
        }

        public final Map<Long, Integer> component3() {
            return this.applicationsPosition;
        }

        /* renamed from: component4, reason: from getter */
        public final ApplicationCommandOption getShowErrorForOption() {
            return this.showErrorForOption;
        }

        public final Map<IntRange, Autocompletable> component5() {
            return this.inputAutocompleteMap;
        }

        public final InputState copy(CharSequence currentInput, ApplicationCommand selectedCommand, Map<Long, Integer> applicationsPosition, ApplicationCommandOption showErrorForOption, Map<IntRange, ? extends Autocompletable> inputAutocompleteMap) {
            m.checkNotNullParameter(currentInput, "currentInput");
            m.checkNotNullParameter(applicationsPosition, "applicationsPosition");
            m.checkNotNullParameter(inputAutocompleteMap, "inputAutocompleteMap");
            return new InputState(currentInput, selectedCommand, applicationsPosition, showErrorForOption, inputAutocompleteMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputState)) {
                return false;
            }
            InputState inputState = (InputState) other;
            return m.areEqual(this.currentInput, inputState.currentInput) && m.areEqual(this.selectedCommand, inputState.selectedCommand) && m.areEqual(this.applicationsPosition, inputState.applicationsPosition) && m.areEqual(this.showErrorForOption, inputState.showErrorForOption) && m.areEqual(this.inputAutocompleteMap, inputState.inputAutocompleteMap);
        }

        public final Map<Long, Integer> getApplicationsPosition() {
            return this.applicationsPosition;
        }

        public final CharSequence getCurrentInput() {
            return this.currentInput;
        }

        public final Map<IntRange, Autocompletable> getInputAutocompleteMap() {
            return this.inputAutocompleteMap;
        }

        public final ApplicationCommand getSelectedCommand() {
            return this.selectedCommand;
        }

        public final ApplicationCommandOption getShowErrorForOption() {
            return this.showErrorForOption;
        }

        public int hashCode() {
            CharSequence charSequence = this.currentInput;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            ApplicationCommand applicationCommand = this.selectedCommand;
            int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
            Map<Long, Integer> map = this.applicationsPosition;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            ApplicationCommandOption applicationCommandOption = this.showErrorForOption;
            int iHashCode4 = (iHashCode3 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0)) * 31;
            Map<IntRange, Autocompletable> map2 = this.inputAutocompleteMap;
            return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
        }

        public final void setApplicationsPosition(Map<Long, Integer> map) {
            m.checkNotNullParameter(map, "<set-?>");
            this.applicationsPosition = map;
        }

        public String toString() {
            StringBuilder sbU = a.U("InputState(currentInput=");
            sbU.append(this.currentInput);
            sbU.append(", selectedCommand=");
            sbU.append(this.selectedCommand);
            sbU.append(", applicationsPosition=");
            sbU.append(this.applicationsPosition);
            sbU.append(", showErrorForOption=");
            sbU.append(this.showErrorForOption);
            sbU.append(", inputAutocompleteMap=");
            return a.M(sbU, this.inputAutocompleteMap, ")");
        }

        public /* synthetic */ InputState(String str, ApplicationCommand applicationCommand, Map map, ApplicationCommandOption applicationCommandOption, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : applicationCommand, (i & 4) != 0 ? new HashMap() : map, (i & 8) == 0 ? applicationCommandOption : null, (i & 16) != 0 ? h0.emptyMap() : map2);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class SelectionState {
        private final String input;
        private final IntRange selection;

        public SelectionState(String str, IntRange intRange) {
            m.checkNotNullParameter(str, "input");
            m.checkNotNullParameter(intRange, "selection");
            this.input = str;
            this.selection = intRange;
        }

        public static /* synthetic */ SelectionState copy$default(SelectionState selectionState, String str, IntRange intRange, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selectionState.input;
            }
            if ((i & 2) != 0) {
                intRange = selectionState.selection;
            }
            return selectionState.copy(str, intRange);
        }

        /* renamed from: component1, reason: from getter */
        public final String getInput() {
            return this.input;
        }

        /* renamed from: component2, reason: from getter */
        public final IntRange getSelection() {
            return this.selection;
        }

        public final SelectionState copy(String input, IntRange selection) {
            m.checkNotNullParameter(input, "input");
            m.checkNotNullParameter(selection, "selection");
            return new SelectionState(input, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectionState)) {
                return false;
            }
            SelectionState selectionState = (SelectionState) other;
            return m.areEqual(this.input, selectionState.input) && m.areEqual(this.selection, selectionState.selection);
        }

        public final String getInput() {
            return this.input;
        }

        public final IntRange getSelection() {
            return this.selection;
        }

        public int hashCode() {
            String str = this.input;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            IntRange intRange = this.selection;
            return iHashCode + (intRange != null ? intRange.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("SelectionState(input=");
            sbU.append(this.input);
            sbU.append(", selection=");
            sbU.append(this.selection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<Application> applications;
        private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
        private final WidgetChatInputDiscoveryCommandsModel browserCommands;
        private final Channel channel;
        private final Map<String, Map<String, CommandAutocompleteState>> commandOptionAutocompleteItems;
        private final List<String> frecencyCommandIds;
        private final List<ApplicationCommand> frecencyCommands;
        private final List<ApplicationCommand> queriedCommands;
        private final long userId;
        private final List<Long> userRoles;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(long j, List<Long> list, Channel channel, List<? extends ApplicationCommand> list2, List<Application> list3, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<String> list4, List<? extends ApplicationCommand> list5) {
            m.checkNotNullParameter(list, "userRoles");
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(list2, "queriedCommands");
            m.checkNotNullParameter(list3, "applications");
            m.checkNotNullParameter(map, "commandOptionAutocompleteItems");
            m.checkNotNullParameter(map2, "autocompletables");
            m.checkNotNullParameter(list4, "frecencyCommandIds");
            m.checkNotNullParameter(list5, "frecencyCommands");
            this.userId = j;
            this.userRoles = list;
            this.channel = channel;
            this.queriedCommands = list2;
            this.applications = list3;
            this.commandOptionAutocompleteItems = map;
            this.autocompletables = map2;
            this.browserCommands = widgetChatInputDiscoveryCommandsModel;
            this.frecencyCommandIds = list4;
            this.frecencyCommands = list5;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, long j, List list, Channel channel, List list2, List list3, Map map, Map map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list4, List list5, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.userId : j, (i & 2) != 0 ? storeState.userRoles : list, (i & 4) != 0 ? storeState.channel : channel, (i & 8) != 0 ? storeState.queriedCommands : list2, (i & 16) != 0 ? storeState.applications : list3, (i & 32) != 0 ? storeState.commandOptionAutocompleteItems : map, (i & 64) != 0 ? storeState.autocompletables : map2, (i & 128) != 0 ? storeState.browserCommands : widgetChatInputDiscoveryCommandsModel, (i & 256) != 0 ? storeState.frecencyCommandIds : list4, (i & 512) != 0 ? storeState.frecencyCommands : list5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        public final List<ApplicationCommand> component10() {
            return this.frecencyCommands;
        }

        public final List<Long> component2() {
            return this.userRoles;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final List<ApplicationCommand> component4() {
            return this.queriedCommands;
        }

        public final List<Application> component5() {
            return this.applications;
        }

        public final Map<String, Map<String, CommandAutocompleteState>> component6() {
            return this.commandOptionAutocompleteItems;
        }

        public final Map<LeadingIdentifier, Set<Autocompletable>> component7() {
            return this.autocompletables;
        }

        /* renamed from: component8, reason: from getter */
        public final WidgetChatInputDiscoveryCommandsModel getBrowserCommands() {
            return this.browserCommands;
        }

        public final List<String> component9() {
            return this.frecencyCommandIds;
        }

        public final StoreState copy(long userId, List<Long> userRoles, Channel channel, List<? extends ApplicationCommand> queriedCommands, List<Application> applications, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> commandOptionAutocompleteItems, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, WidgetChatInputDiscoveryCommandsModel browserCommands, List<String> frecencyCommandIds, List<? extends ApplicationCommand> frecencyCommands) {
            m.checkNotNullParameter(userRoles, "userRoles");
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(queriedCommands, "queriedCommands");
            m.checkNotNullParameter(applications, "applications");
            m.checkNotNullParameter(commandOptionAutocompleteItems, "commandOptionAutocompleteItems");
            m.checkNotNullParameter(autocompletables, "autocompletables");
            m.checkNotNullParameter(frecencyCommandIds, "frecencyCommandIds");
            m.checkNotNullParameter(frecencyCommands, "frecencyCommands");
            return new StoreState(userId, userRoles, channel, queriedCommands, applications, commandOptionAutocompleteItems, autocompletables, browserCommands, frecencyCommandIds, frecencyCommands);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.userId == storeState.userId && m.areEqual(this.userRoles, storeState.userRoles) && m.areEqual(this.channel, storeState.channel) && m.areEqual(this.queriedCommands, storeState.queriedCommands) && m.areEqual(this.applications, storeState.applications) && m.areEqual(this.commandOptionAutocompleteItems, storeState.commandOptionAutocompleteItems) && m.areEqual(this.autocompletables, storeState.autocompletables) && m.areEqual(this.browserCommands, storeState.browserCommands) && m.areEqual(this.frecencyCommandIds, storeState.frecencyCommandIds) && m.areEqual(this.frecencyCommands, storeState.frecencyCommands);
        }

        public final List<Application> getApplications() {
            return this.applications;
        }

        public final Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
            return this.autocompletables;
        }

        public final WidgetChatInputDiscoveryCommandsModel getBrowserCommands() {
            return this.browserCommands;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<String, Map<String, CommandAutocompleteState>> getCommandOptionAutocompleteItems() {
            return this.commandOptionAutocompleteItems;
        }

        public final List<String> getFrecencyCommandIds() {
            return this.frecencyCommandIds;
        }

        public final List<ApplicationCommand> getFrecencyCommands() {
            return this.frecencyCommands;
        }

        public final List<ApplicationCommand> getQueriedCommands() {
            return this.queriedCommands;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final List<Long> getUserRoles() {
            return this.userRoles;
        }

        public int hashCode() {
            int iA = a0.a.a.b.a(this.userId) * 31;
            List<Long> list = this.userRoles;
            int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            List<ApplicationCommand> list2 = this.queriedCommands;
            int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Application> list3 = this.applications;
            int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
            Map<String, Map<String, CommandAutocompleteState>> map = this.commandOptionAutocompleteItems;
            int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
            Map<LeadingIdentifier, Set<Autocompletable>> map2 = this.autocompletables;
            int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
            WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.browserCommands;
            int iHashCode7 = (iHashCode6 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0)) * 31;
            List<String> list4 = this.frecencyCommandIds;
            int iHashCode8 = (iHashCode7 + (list4 != null ? list4.hashCode() : 0)) * 31;
            List<ApplicationCommand> list5 = this.frecencyCommands;
            return iHashCode8 + (list5 != null ? list5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(userId=");
            sbU.append(this.userId);
            sbU.append(", userRoles=");
            sbU.append(this.userRoles);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", queriedCommands=");
            sbU.append(this.queriedCommands);
            sbU.append(", applications=");
            sbU.append(this.applications);
            sbU.append(", commandOptionAutocompleteItems=");
            sbU.append(this.commandOptionAutocompleteItems);
            sbU.append(", autocompletables=");
            sbU.append(this.autocompletables);
            sbU.append(", browserCommands=");
            sbU.append(this.browserCommands);
            sbU.append(", frecencyCommandIds=");
            sbU.append(this.frecencyCommandIds);
            sbU.append(", frecencyCommands=");
            return a.L(sbU, this.frecencyCommands, ")");
        }

        public /* synthetic */ StoreState(long j, List list, Channel channel, List list2, List list3, Map map, Map map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, channel, (i & 8) != 0 ? n.emptyList() : list2, (i & 16) != 0 ? n.emptyList() : list3, (i & 32) != 0 ? h0.emptyMap() : map, (i & 64) != 0 ? h0.emptyMap() : map2, (i & 128) != 0 ? null : widgetChatInputDiscoveryCommandsModel, (i & 256) != 0 ? n.emptyList() : list4, (i & 512) != 0 ? n.emptyList() : list5);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandType.USER.ordinal()] = 1;
            iArr[ApplicationCommandType.CHANNEL.ordinal()] = 2;
            iArr[ApplicationCommandType.ROLE.ordinal()] = 3;
            iArr[ApplicationCommandType.MENTIONABLE.ordinal()] = 4;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutocompleteViewModel(Long l, AppFlexInputViewModel appFlexInputViewModel, StoreApplicationCommands storeApplicationCommands, StoreExperiments storeExperiments, int i, int i2, int i3, Observable observable, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        Long l2 = (i4 & 1) != 0 ? null : l;
        StoreApplicationCommands applicationCommands = (i4 & 4) != 0 ? StoreStream.INSTANCE.getApplicationCommands() : storeApplicationCommands;
        if ((i4 & 128) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, l2, companion2.getApplicationCommands(), companion2.getApplicationComandFrecency());
        } else {
            observableAccess$observeStores = observable;
        }
        this(l2, appFlexInputViewModel, applicationCommands, storeExperiments, i, i2, i3, observableAccess$observeStores);
    }

    public static final /* synthetic */ BehaviorSubject access$getEvents$p(AutocompleteViewModel autocompleteViewModel) {
        return autocompleteViewModel.events;
    }

    public static final /* synthetic */ void access$handleAutocompleteInputSelectionModel(AutocompleteViewModel autocompleteViewModel, AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        autocompleteViewModel.handleAutocompleteInputSelectionModel(autocompleteInputSelectionModel);
    }

    public static final /* synthetic */ void access$handleInputSelectionModel(AutocompleteViewModel autocompleteViewModel, InputSelectionModel inputSelectionModel) throws IOException {
        autocompleteViewModel.handleInputSelectionModel(inputSelectionModel);
    }

    public static final /* synthetic */ InputSelectionModel access$handleSelectionWithInputModel(AutocompleteViewModel autocompleteViewModel, IntRange intRange, MentionInputModel mentionInputModel) {
        return autocompleteViewModel.handleSelectionWithInputModel(intRange, mentionInputModel);
    }

    public static final /* synthetic */ void access$handleStoreState(AutocompleteViewModel autocompleteViewModel, StoreState storeState) {
        autocompleteViewModel.handleStoreState(storeState);
    }

    private final InputEditTextAction applyCommandOptionSpans(MentionInputModel.VerifiedCommandInputModel model, ApplicationCommandOption selectedOption, Set<ApplicationCommandOption> showError) {
        Object value;
        AutocompleteViewModel autocompleteViewModel = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ApplicationCommandOption applicationCommandOption : model.getInputCommandOptionsRanges().keySet()) {
            boolean z2 = !showError.contains(applicationCommandOption);
            OptionRange optionRange = model.getInputCommandOptionsRanges().get(applicationCommandOption);
            if (optionRange != null) {
                int last = optionRange.getParam().getLast();
                if (!m.areEqual(selectedOption, applicationCommandOption)) {
                    last = optionRange.getValue().getLast();
                }
                int i = last;
                int i2 = autocompleteViewModel.defaultCommandOptionBackgroundColor;
                String string = null;
                Integer numValueOf = !z2 ? Integer.valueOf(autocompleteViewModel.commandOptionErrorColor) : null;
                CommandOptionValue commandOptionValue = model.getInputCommandOptionValues().get(applicationCommandOption);
                if (commandOptionValue != null && (value = commandOptionValue.getValue()) != null) {
                    string = value.toString();
                }
                linkedHashMap.put(new IntRange(optionRange.getParam().getFirst(), i), d0.t.m.listOf(new ApplicationCommandSpan(applicationCommandOption, string, optionRange.getParam().getFirst(), i, DimenUtils.dpToPixels(4), DimenUtils.dpToPixels(4), i2, DimenUtils.dpToPixels(4), numValueOf, false, AutocompleteViewModel$applyCommandOptionSpans$1$1$1.INSTANCE, 512, null)));
            }
            autocompleteViewModel = this;
        }
        return new InputEditTextAction.ReplacePillSpans(model.getInput(), linkedHashMap);
    }

    private final void checkForCommandsToQuery(CharSequence input, CharSequence previousInput, Channel channel) {
        AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
        String commandPrefix = autocompleteCommandUtils.getCommandPrefix(input);
        String commandPrefix2 = previousInput != null ? autocompleteCommandUtils.getCommandPrefix(previousInput) : null;
        if (commandPrefix == null || !(!m.areEqual(commandPrefix, commandPrefix2))) {
            return;
        }
        queryCommandsFromCommandPrefixToken((String) w.split$default((CharSequence) commandPrefix, new String[]{" "}, false, 0, 6, (Object) null).get(0), channel);
    }

    private final boolean commandCleared(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        MentionInputModel.VerifiedCommandInputModel inputModel;
        InputCommandContext inputCommandContext;
        MentionInputModel.VerifiedCommandInputModel inputModel2;
        InputCommandContext inputCommandContext2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommand selectedCommand = (commandInputSelectionModel == null || (inputModel2 = commandInputSelectionModel.getInputModel()) == null || (inputCommandContext2 = inputModel2.getInputCommandContext()) == null) ? null : inputCommandContext2.getSelectedCommand();
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        ApplicationCommand selectedCommand2 = (commandInputSelectionModel2 == null || (inputModel = commandInputSelectionModel2.getInputModel()) == null || (inputCommandContext = inputModel.getInputCommandContext()) == null) ? null : inputCommandContext.getSelectedCommand();
        if ((selectedCommand != null ? selectedCommand.getId() : null) == null) {
            if ((selectedCommand2 != null ? selectedCommand2.getId() : null) != null) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    private final InputEditTextAction generateSpanUpdates(MentionInputModel model) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<IntRange, Autocompletable> entry : model.getInputMentionsMap().entrySet()) {
            IntRange key = entry.getKey();
            Autocompletable value = entry.getValue();
            if (!(value instanceof ApplicationCommandAutocompletable)) {
                if (!(value instanceof RoleAutocompletable)) {
                    value = null;
                }
                RoleAutocompletable roleAutocompletable = (RoleAutocompletable) value;
                linkedHashMap.put(key, n.listOf((Object[]) new MetricAffectingSpan[]{new FontColorSpan(RoleUtils.getOpaqueColor(roleAutocompletable != null ? roleAutocompletable.getRole() : null, this.defaultMentionColor)), new StyleSpan(1)}));
            }
        }
        return new InputEditTextAction.ReplaceCharacterStyleSpans(model.getInput(), linkedHashMap);
    }

    public static /* synthetic */ ApplicationCommandData getApplicationSendData$default(AutocompleteViewModel autocompleteViewModel, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = null;
        }
        return autocompleteViewModel.getApplicationSendData(applicationCommandOption);
    }

    private final AutocompleteViewState getAutocompleteViewState(String token, List<? extends Autocompletable> autocompletables, List<AutocompleteStickerItem> stickers, boolean isAutocompletable) {
        List mutableList = u.toMutableList((Collection) autocompletables);
        if (this.emojiAutocompleteUpsellEnabled) {
            boolean reducedMotionEnabled = StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
            List listFilterIsInstance = t.filterIsInstance(autocompletables, EmojiAutocompletable.class);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listFilterIsInstance) {
                if (!((EmojiAutocompletable) obj).getEmoji().isUsable()) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                List listTake = u.take(arrayList, 3);
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(listTake, 10));
                Iterator it = listTake.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((EmojiAutocompletable) it.next()).getEmoji());
                }
                mutableList.add(new EmojiUpsellPlaceholder(size, arrayList2, reducedMotionEnabled && ((EmojiAutocompletable) u.first((List) arrayList)).getAnimationsEnabled()));
                mutableList.removeAll(arrayList);
            }
        }
        return (isAutocompletable || (mutableList.isEmpty() ^ true) || (stickers.isEmpty() ^ true)) ? new AutocompleteViewState.Autocomplete(false, false, isAutocompletable, mutableList, stickers, token, 2, null) : AutocompleteViewState.Hidden.INSTANCE;
    }

    public static /* synthetic */ AutocompleteViewState getAutocompleteViewState$default(AutocompleteViewModel autocompleteViewModel, String str, List list, List list2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return autocompleteViewModel.getAutocompleteViewState(str, list, list2, z2);
    }

    private final User getChannelBot(Channel channel) {
        User userA = ChannelUtils.a(channel);
        if (userA == null) {
            return null;
        }
        if (!userA.getIsBot()) {
            userA = null;
        }
        return userA;
    }

    private final SelectedCommandViewState getSelectedCommandViewState(AutocompleteInputSelectionModel model) {
        InputSelectionModel inputSelectionModel = model.getInputSelectionModel();
        if (inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel) {
            ApplicationCommand selectedCommand = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandContext().getSelectedCommand();
            Application selectedApplication = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandContext().getSelectedApplication();
            return (selectedCommand == null || selectedApplication == null) ? SelectedCommandViewState.Hidden.INSTANCE : new SelectedCommandViewState.SelectedCommand(selectedCommand, ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getSelectedCommandOption(), model.getShowErrorsForOptions(), ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValidity(), selectedApplication);
        }
        if (inputSelectionModel instanceof InputSelectionModel.MessageInputSelectionModel) {
            return SelectedCommandViewState.Hidden.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @MainThread
    private final void handleAutocompleteInputSelectionModel(AutocompleteInputSelectionModel model) {
        AutocompleteViewState autocompleteViewState;
        CommandAutocompleteState commandAutocompleteState;
        StoreState storeState;
        WidgetChatInputDiscoveryCommandsModel browserCommands;
        WidgetChatInputDiscoveryCommandsModel browserCommands2;
        MentionToken autocompleteToken = model.getAutocompleteToken();
        AutocompleteViewState autocomplete = null;
        jumpedApplicationId = null;
        Long jumpedApplicationId = null;
        autocomplete = null;
        autocomplete = null;
        autocomplete = null;
        if (m.areEqual(model.getInputSelectionModel().getInputModel().getInput().toString(), COMMAND_DISCOVER_TOKEN)) {
            StoreState storeState2 = this.storeState;
            if (storeState2 != null && (browserCommands2 = storeState2.getBrowserCommands()) != null) {
                jumpedApplicationId = browserCommands2.getJumpedApplicationId();
            }
            if (jumpedApplicationId != null && ((storeState = this.storeState) == null || (browserCommands = storeState.getBrowserCommands()) == null || browserCommands.getJumpedSequenceId() != this.lastJumpedSequenceId)) {
                Integer num = this.inputState.getApplicationsPosition().get(jumpedApplicationId);
                this.events.onNext(new Event.ScrollAutocompletablesToApplication(jumpedApplicationId.longValue(), num != null ? num.intValue() : 3));
            }
            autocompleteViewState = getApplicationCommandsBrowserViewState();
        } else if (autocompleteToken != null) {
            boolean z2 = false;
            if (model.getInputSelectionModel() instanceof InputSelectionModel.CommandInputSelectionModel) {
                ApplicationCommandOption selectedCommandOption = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getSelectedCommandOption();
                Map<String, CommandAutocompleteState> map = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getCommandOptionAutocompleteItems().get(selectedCommandOption != null ? selectedCommandOption.getName() : null);
                if (map != null) {
                    CommandOptionValue commandOptionValue = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValues().get(selectedCommandOption);
                    commandAutocompleteState = map.get(String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null));
                } else {
                    commandAutocompleteState = null;
                }
                if (selectedCommandOption != null && selectedCommandOption.getAutocomplete()) {
                    z2 = true;
                }
                Boolean bool = ((InputSelectionModel.CommandInputSelectionModel) model.getInputSelectionModel()).getInputModel().getInputCommandOptionValidity().get(selectedCommandOption);
                if (selectedCommandOption != null && selectedCommandOption.getAutocomplete() && !(commandAutocompleteState instanceof CommandAutocompleteState.Choices) && (!m.areEqual(bool, Boolean.TRUE))) {
                    autocomplete = new AutocompleteViewState.Autocomplete(true, commandAutocompleteState instanceof CommandAutocompleteState.Failed, true, n.emptyList(), n.emptyList(), autocompleteToken.getToken());
                } else if (selectedCommandOption != null && selectedCommandOption.getAutocomplete() && m.areEqual(bool, Boolean.TRUE)) {
                    autocomplete = AutocompleteViewState.Hidden.INSTANCE;
                }
            }
            if (autocomplete == null) {
                List<Autocompletable> listFilterMentionsFromToken = AutocompleteModelUtils.INSTANCE.filterMentionsFromToken(autocompleteToken, model.getInputSelectionModel(), model.getFilteredAutocompletables());
                List<Sticker> stickerMatches = model.getStickerMatches();
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(stickerMatches, 10));
                Iterator<T> it = stickerMatches.iterator();
                while (it.hasNext()) {
                    arrayList.add(new AutocompleteStickerItem((Sticker) it.next(), null, 0, 6, null));
                }
                autocompleteViewState = getAutocompleteViewState(autocompleteToken.getToken(), listFilterMentionsFromToken, arrayList, z2);
            } else {
                autocompleteViewState = autocomplete;
            }
        } else {
            autocompleteViewState = AutocompleteViewState.Hidden.INSTANCE;
        }
        SelectedCommandViewState selectedCommandViewState = getSelectedCommandViewState(model);
        ApplicationCommand applicationCommandNewSelectedCommand = newSelectedCommand(model, this.lastAutocompleteInputSelectionModel);
        if (applicationCommandNewSelectedCommand != null) {
            onNewCommandSelected(applicationCommandNewSelectedCommand);
        } else if (commandCleared(model, this.lastAutocompleteInputSelectionModel)) {
            onCommandCleared();
        }
        if (newSelectedCommandOption(model, this.lastAutocompleteInputSelectionModel) != null) {
            this.storeApplicationCommands.clearAutocompleteResults();
        }
        ApplicationCommandOption applicationCommandOptionHasAddedAttachmentOption = hasAddedAttachmentOption(model, this.lastAutocompleteInputSelectionModel);
        if (applicationCommandOptionHasAddedAttachmentOption != null) {
            selectAttachmentOption(applicationCommandOptionHasAddedAttachmentOption);
        }
        this.lastAutocompleteInputSelectionModel = model;
        updateViewState(new ViewState(autocompleteViewState, selectedCommandViewState));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f6  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleInputSelectionModel(InputSelectionModel newModel) throws IOException {
        Set<ApplicationCommandOption> setEmptySet;
        MentionToken commandAutocompleteToken;
        if (newModel.getSelection().getLast() > newModel.getInputModel().getInput().length()) {
            return;
        }
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        InputEditTextAction replacePillSpans = new InputEditTextAction.ReplacePillSpans(newModel.getInputModel().getInput(), null, 2, null);
        boolean z2 = newModel instanceof InputSelectionModel.CommandInputSelectionModel;
        if (z2) {
            AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) newModel;
            ApplicationCommand selectedCommand = commandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
            ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
            if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
                inputSelectionModel = null;
            }
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
            setEmptySet = u.toMutableSet(autocompleteCommandUtils.getErrorsToShowForCommandParameters(selectedCommand, selectedCommandOption, commandInputSelectionModel2 != null ? commandInputSelectionModel2.getSelectedCommandOption() : null, commandInputSelectionModel.getInputModel().getInputCommandOptionValidity(), commandInputSelectionModel.getInputModel().getInputCommandOptionValues()));
            ApplicationCommandOption showErrorForOption = this.inputState.getShowErrorForOption();
            if (showErrorForOption != null) {
                if (m.areEqual(commandInputSelectionModel.getInputModel().getInputCommandOptionValidity().get(showErrorForOption), Boolean.TRUE) || (!m.areEqual(commandInputSelectionModel.getSelectedCommandOption(), showErrorForOption))) {
                    this.inputState = InputState.copy$default(this.inputState, null, null, null, null, null, 23, null);
                } else {
                    setEmptySet.add(showErrorForOption);
                }
            }
            replacePillSpans = applyCommandOptionSpans(commandInputSelectionModel.getInputModel(), commandInputSelectionModel.getSelectedCommandOption(), setEmptySet);
        } else {
            setEmptySet = n0.emptySet();
        }
        Set<ApplicationCommandOption> set = setEmptySet;
        this.editTextAction.onNext(replacePillSpans);
        if (z2) {
            InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel3 = (InputSelectionModel.CommandInputSelectionModel) newModel;
            commandAutocompleteToken = commandInputSelectionModel3.getSelectedCommandOption() != null ? AutocompleteModelUtils.INSTANCE.getCommandAutocompleteToken(commandInputSelectionModel3.getInputModel().getInput(), newModel.getSelection(), commandInputSelectionModel3.getSelectedCommandOption(), InputSelectionModelKt.hasSelectedFreeformInput(newModel), commandInputSelectionModel3.getInputModel().getInputCommandOptionsRanges(), commandInputSelectionModel3.getInputModel().getInputCommandOptionValues()) : AutocompleteModelUtils.INSTANCE.getMessageAutocompleteToken(newModel.getInputModel().getInput(), newModel.getSelection());
        }
        MentionToken mentionToken = commandAutocompleteToken;
        AutocompleteModelUtils autocompleteModelUtils = AutocompleteModelUtils.INSTANCE;
        List<Sticker> stickerMatches = autocompleteModelUtils.getStickerMatches(mentionToken);
        Map<LeadingIdentifier, List<Autocompletable>> mapFilterAutocompletablesForInputContext = autocompleteModelUtils.filterAutocompletablesForInputContext(newModel);
        this.lastChatInputModel = newModel;
        this.autocompleteInputSelectionModelSubject.onNext(new AutocompleteInputSelectionModel(mentionToken, mapFilterAutocompletablesForInputContext, newModel, set, stickerMatches));
    }

    @MainThread
    private final void handleNewChannel(CharSequence currentInput, Channel oldChannel, Channel newChannel) {
        User channelBot = getChannelBot(newChannel);
        Long lValueOf = newChannel.getGuildId() == 0 ? null : Long.valueOf(newChannel.getGuildId());
        boolean z2 = true;
        if (!(!m.areEqual(oldChannel != null ? Long.valueOf(oldChannel.getGuildId()) : null, lValueOf))) {
            if ((oldChannel != null ? Long.valueOf(oldChannel.getGuildId()) : null) != null || lValueOf != null) {
                z2 = false;
            }
        }
        if (channelBot != null) {
            this.storeApplicationCommands.handleDmUserApplication(channelBot);
        } else if (z2) {
            this.storeApplicationCommands.requestFrecencyCommands(lValueOf != null ? lValueOf.longValue() : 0L);
            this.storeApplicationCommands.requestApplications(lValueOf);
        }
        String commandPrefix = currentInput != null ? AutocompleteCommandUtils.INSTANCE.getCommandPrefix(currentInput) : null;
        if (commandPrefix != null) {
            queryCommandsFromCommandPrefixToken(commandPrefix, newChannel);
        }
    }

    private final InputSelectionModel handleSelectionWithInputModel(IntRange selection, MentionInputModel inputModel) {
        if (inputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel = (MentionInputModel.VerifiedCommandInputModel) inputModel;
            return new InputSelectionModel.CommandInputSelectionModel(verifiedCommandInputModel, selection, AutocompleteCommandUtils.INSTANCE.getSelectedCommandOption(selection.getFirst(), verifiedCommandInputModel.getInputCommandOptionsRanges()));
        }
        if (inputModel instanceof MentionInputModel.VerifiedMessageInputModel) {
            return new InputSelectionModel.MessageInputSelectionModel(inputModel, selection);
        }
        throw new NoWhenBranchMatchedException();
    }

    @MainThread
    private final void handleStoreState(StoreState newState) {
        Channel channel;
        StoreState storeState = this.storeState;
        if (storeState == null || (channel = storeState.getChannel()) == null || channel.getId() != newState.getChannel().getId()) {
            CharSequence currentInput = this.inputState.getCurrentInput();
            StoreState storeState2 = this.storeState;
            handleNewChannel(currentInput, storeState2 != null ? storeState2.getChannel() : null, newState.getChannel());
        }
        if (!m.areEqual(this.storeState != null ? r0.getFrecencyCommandIds() : null, newState.getFrecencyCommandIds())) {
            this.storeApplicationCommands.requestFrecencyCommands(newState.getChannel().getGuildId());
        }
        if ((!m.areEqual(this.storeState != null ? r0.getBrowserCommands() : null, newState.getBrowserCommands())) && newState.getBrowserCommands() != null) {
            this.inputState = InputState.copy$default(this.inputState, null, null, getCommandBrowserCommandPositions(newState.getBrowserCommands()), null, null, 27, null);
        }
        this.storeState = newState;
        onDataUpdated(this.inputState, newState);
    }

    private final ApplicationCommandOption hasAddedAttachmentOption(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        Set setEmptySet;
        Set setEmptySet2;
        MentionInputModel.VerifiedCommandInputModel inputModel;
        Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges;
        MentionInputModel.VerifiedCommandInputModel inputModel2;
        Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        if (commandInputSelectionModel == null || (inputModel2 = commandInputSelectionModel.getInputModel()) == null || (inputCommandOptionsRanges2 = inputModel2.getInputCommandOptionsRanges()) == null) {
            setEmptySet = null;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<ApplicationCommandOption, OptionRange> entry : inputCommandOptionsRanges2.entrySet()) {
                if (entry.getKey().getType() == ApplicationCommandType.ATTACHMENT) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            setEmptySet = linkedHashMap.keySet();
        }
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        if (commandInputSelectionModel2 == null || (inputModel = commandInputSelectionModel2.getInputModel()) == null || (inputCommandOptionsRanges = inputModel.getInputCommandOptionsRanges()) == null) {
            setEmptySet2 = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<ApplicationCommandOption, OptionRange> entry2 : inputCommandOptionsRanges.entrySet()) {
                if (entry2.getKey().getType() == ApplicationCommandType.ATTACHMENT) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            setEmptySet2 = linkedHashMap2.keySet();
        }
        if (setEmptySet2 == null) {
            setEmptySet2 = n0.emptySet();
        }
        Set setMinus = o0.minus(setEmptySet, (Iterable) setEmptySet2);
        if (setMinus.size() == 1) {
            return (ApplicationCommandOption) u.first(setMinus);
        }
        return null;
    }

    private final ApplicationCommand newSelectedCommand(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        MentionInputModel.VerifiedCommandInputModel inputModel;
        InputCommandContext inputCommandContext;
        MentionInputModel.VerifiedCommandInputModel inputModel2;
        InputCommandContext inputCommandContext2;
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommand selectedCommand = (commandInputSelectionModel == null || (inputModel2 = commandInputSelectionModel.getInputModel()) == null || (inputCommandContext2 = inputModel2.getInputCommandContext()) == null) ? null : inputCommandContext2.getSelectedCommand();
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        if (!m.areEqual(selectedCommand != null ? selectedCommand.getId() : null, ((commandInputSelectionModel2 == null || (inputModel = commandInputSelectionModel2.getInputModel()) == null || (inputCommandContext = inputModel.getInputCommandContext()) == null) ? null : inputCommandContext.getSelectedCommand()) != null ? r4.getId() : null)) {
            return selectedCommand;
        }
        return null;
    }

    private final ApplicationCommandOption newSelectedCommandOption(AutocompleteInputSelectionModel newModel, AutocompleteInputSelectionModel oldModel) {
        InputSelectionModel inputSelectionModel = newModel.getInputSelectionModel();
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        ApplicationCommandOption selectedCommandOption = commandInputSelectionModel != null ? commandInputSelectionModel.getSelectedCommandOption() : null;
        InputSelectionModel inputSelectionModel2 = oldModel != null ? oldModel.getInputSelectionModel() : null;
        if (!(inputSelectionModel2 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            inputSelectionModel2 = null;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel2;
        if (!m.areEqual(selectedCommandOption != null ? selectedCommandOption.getName() : null, (commandInputSelectionModel2 != null ? commandInputSelectionModel2.getSelectedCommandOption() : null) != null ? r4.getName() : null)) {
            return selectedCommandOption;
        }
        return null;
    }

    private final void onCommandCleared() {
        this.commandAttachments.clear();
        this.flexInputViewModel.onAttachmentsUpdated(n.emptyList());
    }

    private final void onNewCommandSelected(ApplicationCommand newSelectedCommand) {
        this.commandAttachments.clear();
        this.flexInputViewModel.onAttachmentsUpdated(n.emptyList());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreAnalytics analytics = companion.getAnalytics();
        long id2 = companion.getChannelsSelected().getId();
        long applicationId = newSelectedCommand.getApplicationId();
        Long longOrNull = s.toLongOrNull(newSelectedCommand.getId());
        analytics.trackApplicationCommandSelected(id2, applicationId, longOrNull != null ? longOrNull.longValue() : 0L);
    }

    @MainThread
    private final InputEditTextAction onPreAutocompleteCompute(CharSequence input) {
        return replacementSpanCommandParamDeletion(input);
    }

    @MainThread
    private final void queryCommandsFromCommandPrefixToken(String commandPrefix, Channel channel) {
        User channelBot = getChannelBot(channel);
        Long lValueOf = channelBot != null ? Long.valueOf(channelBot.getId()) : null;
        long guildId = channel.getGuildId();
        if (commandPrefix.length() <= 1 && lValueOf == null) {
            this.storeApplicationCommands.clearQueryCommands();
        }
        if (commandPrefix.length() == 1) {
            this.storeApplicationCommands.requestInitialApplicationCommands(Long.valueOf(guildId), lValueOf, true);
            return;
        }
        if (commandPrefix.length() <= 1 || lValueOf != null) {
            return;
        }
        StoreApplicationCommands storeApplicationCommands = this.storeApplicationCommands;
        Long lValueOf2 = Long.valueOf(guildId);
        String strSubstring = commandPrefix.substring(1);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        storeApplicationCommands.requestApplicationCommandsQuery(lValueOf2, strSubstring);
    }

    private final void removeAttachment(ApplicationCommandOption commandOption) {
        MentionInputModel inputModel;
        CharSequence input;
        InputSelectionModel inputSelectionModel;
        ApplicationCommand selectedCommand;
        OptionRange optionRange;
        Attachment<?> attachment = this.commandAttachments.get(commandOption);
        if (attachment != null) {
            this.commandAttachments.remove(commandOption);
            this.flexInputViewModel.removeAttachment(attachment);
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            if (inputSelectionModel2 == null || (inputModel = inputSelectionModel2.getInputModel()) == null || (input = inputModel.getInput()) == null || (inputSelectionModel = this.lastChatInputModel) == null || (selectedCommand = InputSelectionModelKt.getSelectedCommand(inputSelectionModel)) == null || (optionRange = AutocompleteCommandUtils.INSTANCE.findOptionRanges(input, selectedCommand, this.commandAttachments).get(commandOption)) == null) {
                return;
            }
            this.editTextAction.onNext(new InputEditTextAction.RemoveText(input, new IntRange(optionRange.getParam().getFirst(), optionRange.getValue().getLast()), optionRange.getParam().getFirst()));
        }
    }

    @MainThread
    private final InputEditTextAction replacementSpanCommandParamDeletion(CharSequence input) {
        String string = input.toString();
        SpannedString spannedStringValueOf = SpannedString.valueOf(input);
        m.checkNotNullExpressionValue(spannedStringValueOf, "valueOf(this)");
        Object[] spans = spannedStringValueOf.getSpans(0, input.length(), SimpleRoundedBackgroundSpan.class);
        m.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (SimpleRoundedBackgroundSpan simpleRoundedBackgroundSpan : (SimpleRoundedBackgroundSpan[]) spans) {
            IntRange intRange = new IntRange(spannedStringValueOf.getSpanStart(simpleRoundedBackgroundSpan), spannedStringValueOf.getSpanEnd(simpleRoundedBackgroundSpan));
            Character orNull = y.getOrNull(string, intRange.getLast());
            boolean z2 = orNull != null && orNull.charValue() == ':';
            int first = intRange.getFirst();
            int last = intRange.getLast();
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = string.substring(first, last);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (simpleRoundedBackgroundSpan instanceof ApplicationCommandSpan) {
                ApplicationCommandSpan applicationCommandSpan = (ApplicationCommandSpan) simpleRoundedBackgroundSpan;
                if (applicationCommandSpan.getCommandOption().getType() == ApplicationCommandType.ATTACHMENT) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(applicationCommandSpan.getCommandOption().getName());
                    sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    Attachment<?> attachment = this.commandAttachments.get(applicationCommandSpan.getCommandOption());
                    sb.append(attachment != null ? attachment.getDisplayName() : null);
                    if (!w.contains$default((CharSequence) strSubstring, (CharSequence) sb.toString(), false, 2, (Object) null)) {
                        removeAttachment(applicationCommandSpan.getCommandOption());
                        return new InputEditTextAction.RemoveText(string, new IntRange(intRange.getFirst(), intRange.getLast()), Math.min(intRange.getFirst() + 1, string.length() - (intRange.getLast() - intRange.getFirst())));
                    }
                }
            }
            if (!w.contains$default((CharSequence) strSubstring, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null) && !z2) {
                return new InputEditTextAction.RemoveText(string, new IntRange(intRange.getFirst(), intRange.getLast()), intRange.getFirst());
            }
        }
        return new InputEditTextAction.None(input);
    }

    private final void selectAttachmentOption(ApplicationCommandOption applicationCommandsOption) {
        Attachment<?> attachment = this.commandAttachments.get(applicationCommandsOption);
        if (attachment != null) {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new Event.PreviewAttachment(attachment));
        } else {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new Event.PickAttachment(applicationCommandsOption));
        }
    }

    @MainThread
    private final void selectFirstInvalidCommandOption() {
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        MentionInputModel inputModel = inputSelectionModel != null ? inputSelectionModel.getInputModel() : null;
        if (inputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = ((MentionInputModel.VerifiedCommandInputModel) inputModel).getInputCommandOptionValidity();
            for (ApplicationCommandOption applicationCommandOption : inputCommandOptionValidity.keySet()) {
                if (m.areEqual(inputCommandOptionValidity.get(applicationCommandOption), Boolean.FALSE)) {
                    this.inputState = InputState.copy$default(this.inputState, null, null, null, applicationCommandOption, null, 23, null);
                    selectCommandOption(applicationCommandOption);
                    return;
                }
            }
        }
    }

    public final void checkEmojiAutocompleteUpsellViewed(List<? extends Autocompletable> visibleItems) {
        Autocompletable autocompletablePrevious;
        m.checkNotNullParameter(visibleItems, "visibleItems");
        if (this.emojiAutocompleteUpsellEnabled && this.logEmojiAutocompleteUpsellViewed) {
            ListIterator<? extends Autocompletable> listIterator = visibleItems.listIterator(visibleItems.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    autocompletablePrevious = null;
                    break;
                } else {
                    autocompletablePrevious = listIterator.previous();
                    if (autocompletablePrevious instanceof EmojiUpsellPlaceholder) {
                        break;
                    }
                }
            }
            if (autocompletablePrevious != null) {
                this.logEmojiAutocompleteUpsellViewed = false;
                StoreStream.INSTANCE.getAnalytics().emojiAutocompleteUpsellInlineViewed();
            }
        }
    }

    @MainThread
    public final AutocompleteViewState getApplicationCommandsBrowserViewState() {
        Experiment userExperiment;
        StoreState storeState = this.storeState;
        if (storeState == null || storeState.getBrowserCommands() == null) {
            return AutocompleteViewState.Hidden.INSTANCE;
        }
        boolean z2 = (storeState.getFrecencyCommands().isEmpty() ^ true) && (userExperiment = this.storeExperiments.getUserExperiment("2021-09_android_app_commands_frecency", true)) != null && userExperiment.getBucket() == 1;
        List<ApplicationCommand> frecencyCommands = z2 ? storeState.getFrecencyCommands() : n.emptyList();
        List<Application> applications = storeState.getApplications();
        ArrayList arrayList = new ArrayList();
        for (Object obj : applications) {
            Application application = (Application) obj;
            if (application.getCommandCount() > 0 || (z2 && application.getId() == -2 && (storeState.getFrecencyCommands().isEmpty() ^ true))) {
                arrayList.add(obj);
            }
        }
        return new AutocompleteViewState.CommandBrowser(frecencyCommands, arrayList, storeState.getBrowserCommands());
    }

    public final ApplicationCommandData getApplicationSendData(ApplicationCommandOption focusedOption) {
        AutocompleteModelUtils autocompleteModelUtils = AutocompleteModelUtils.INSTANCE;
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
        StoreState storeState = this.storeState;
        List<Application> applications = storeState != null ? storeState.getApplications() : null;
        if (applications == null) {
            applications = n.emptyList();
        }
        List<Application> list = applications;
        StoreState storeState2 = this.storeState;
        List<ApplicationCommand> queriedCommands = storeState2 != null ? storeState2.getQueriedCommands() : null;
        return autocompleteModelUtils.getApplicationSendData(autocompleteInputSelectionModel, focusedOption, list, queriedCommands != null ? queriedCommands : n.emptyList(), this.commandAttachments);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Map<ApplicationCommandOption, Attachment<?>> getCommandAttachments() {
        return c.A(this.commandAttachments);
    }

    @MainThread
    public final Map<Long, Integer> getCommandBrowserCommandPositions(WidgetChatInputDiscoveryCommandsModel discoveryCommands) {
        m.checkNotNullParameter(discoveryCommands, "discoveryCommands");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = 0;
        for (Pair<Application, List<Autocompletable>> pair : discoveryCommands.getCommandsByApplication()) {
            Application applicationComponent1 = pair.component1();
            List<Autocompletable> listComponent2 = pair.component2();
            Iterator<Autocompletable> it = listComponent2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (!(it.next() instanceof ApplicationCommandLoadingPlaceholder)) {
                    break;
                }
                i++;
            }
            linkedHashMap.put(Long.valueOf(applicationComponent1.getId()), Integer.valueOf(f.coerceAtLeast(i, 0) + size));
            size += listComponent2.size();
        }
        return linkedHashMap;
    }

    public final int getCommandOptionErrorColor() {
        return this.commandOptionErrorColor;
    }

    public final int getDefaultCommandOptionBackgroundColor() {
        return this.defaultCommandOptionBackgroundColor;
    }

    public final int getDefaultMentionColor() {
        return this.defaultMentionColor;
    }

    public final boolean getEmojiAutocompleteUpsellEnabled() {
        return this.emojiAutocompleteUpsellEnabled;
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    public final InputState getInputState() {
        return this.inputState;
    }

    public final int getLastJumpedSequenceId() {
        return this.lastJumpedSequenceId;
    }

    public final StoreApplicationCommands getStoreApplicationCommands() {
        return this.storeApplicationCommands;
    }

    public final StoreState getStoreState() {
        return this.storeState;
    }

    public final Observable<InputEditTextAction> observeEditTextActions() {
        BehaviorSubject<InputEditTextAction> behaviorSubject = this.editTextAction;
        m.checkNotNullExpressionValue(behaviorSubject, "editTextAction");
        return behaviorSubject;
    }

    public final Observable<Event> observeEvents() {
        BehaviorSubject<Event> behaviorSubject = this.events;
        m.checkNotNullExpressionValue(behaviorSubject, "events");
        return behaviorSubject;
    }

    public final void onApplicationCommandSendError() {
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        Object obj = null;
        MentionInputModel inputModel = inputSelectionModel != null ? inputSelectionModel.getInputModel() : null;
        if (inputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel = (MentionInputModel.VerifiedCommandInputModel) inputModel;
            ApplicationCommand selectedCommand = verifiedCommandInputModel.getInputCommandContext().getSelectedCommand();
            if (selectedCommand != null) {
                Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity = verifiedCommandInputModel.getInputCommandOptionValidity();
                Iterator<T> it = selectedCommand.getOptions().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (m.areEqual(inputCommandOptionValidity.get((ApplicationCommandOption) next), Boolean.FALSE)) {
                        obj = next;
                        break;
                    }
                }
                ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) obj;
                if (applicationCommandOption != null) {
                    long applicationId = selectedCommand.getApplicationId();
                    Long longOrNull = selectedCommand instanceof ApplicationSubCommand ? s.toLongOrNull(((ApplicationSubCommand) selectedCommand).getRootCommand().getId()) : s.toLongOrNull(selectedCommand.getId());
                    if (longOrNull != null) {
                        long jLongValue = longOrNull.longValue();
                        selectFirstInvalidCommandOption();
                        StoreStream.INSTANCE.getAnalytics().trackApplicationCommandValidationFailure(applicationId, jLongValue, applicationCommandOption.getType().toString(), applicationCommandOption.getRequired());
                    }
                }
            }
        }
    }

    public final void onAttachmentRemoved(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        ApplicationCommandOption applicationCommandOption = this.selectedOptionForAttachment;
        if (applicationCommandOption != null) {
            removeAttachment(applicationCommandOption);
        }
    }

    public final void onAutocompleteItemsUpdated() {
        this.logEmojiAutocompleteUpsellViewed = true;
    }

    public final void onCommandsBrowserScroll(int firstVisibleItemPosition, int lastVisibleItemPosition, int totalItems) {
        WidgetChatInputDiscoveryCommandsModel browserCommands;
        WidgetChatInputDiscoveryCommandsModel browserCommands2;
        StoreState storeState = this.storeState;
        if (storeState == null || (browserCommands2 = storeState.getBrowserCommands()) == null || !browserCommands2.getHasMoreBefore() || firstVisibleItemPosition > 3) {
            StoreState storeState2 = this.storeState;
            if (storeState2 != null && (browserCommands = storeState2.getBrowserCommands()) != null && browserCommands.getHasMoreAfter() && lastVisibleItemPosition >= (totalItems - 3) - 6) {
                StoreStream.INSTANCE.getApplicationCommands().requestLoadMoreDown();
            }
        } else {
            StoreStream.INSTANCE.getApplicationCommands().requestLoadMoreUp();
        }
        StoreStream.INSTANCE.getAnalytics().trackApplicationCommandBrowserScrolled();
    }

    @MainThread
    public final InputEditTextAction onDataUpdated(InputState inputState, StoreState storeState) {
        MentionInputModel verifiedMessageInputModel;
        m.checkNotNullParameter(inputState, "inputState");
        if (storeState == null) {
            return new InputEditTextAction.None(inputState.getCurrentInput());
        }
        AutocompleteApplicationCommands autocompleteApplicationCommands = new AutocompleteApplicationCommands(storeState.getApplications(), storeState.getQueriedCommands(), storeState.getBrowserCommands());
        AutocompleteInputModel autocompleteInputModel = new AutocompleteInputModel(inputState.getCurrentInput(), storeState.getAutocompletables(), autocompleteApplicationCommands);
        AutocompleteCommandUtils autocompleteCommandUtils = AutocompleteCommandUtils.INSTANCE;
        InputCommandContext inputCommandContext = autocompleteCommandUtils.getInputCommandContext(autocompleteInputModel.getInput(), storeState.getUserId(), storeState.getUserRoles(), autocompleteApplicationCommands, inputState.getSelectedCommand());
        ChatInputMentionsMap chatInputMentionsMapMapInputToMentions = AutocompleteModelUtils.INSTANCE.mapInputToMentions(autocompleteInputModel.getInput().toString(), storeState.getAutocompletables(), inputState.getInputAutocompleteMap(), inputCommandContext.getIsCommand());
        if (inputCommandContext.getSelectedCommand() != null) {
            ApplicationCommand selectedCommand = inputCommandContext.getSelectedCommand();
            Map<ApplicationCommandOption, OptionRange> mapFindOptionRanges = autocompleteCommandUtils.findOptionRanges(autocompleteInputModel.getInput(), selectedCommand, this.commandAttachments);
            Map<ApplicationCommandOption, CommandOptionValue> commandOptions = autocompleteCommandUtils.parseCommandOptions(autocompleteInputModel.getInput(), selectedCommand, chatInputMentionsMapMapInputToMentions, this.commandAttachments);
            verifiedMessageInputModel = new MentionInputModel.VerifiedCommandInputModel(autocompleteInputModel.getInput(), autocompleteInputModel.getAutocompletables(), chatInputMentionsMapMapInputToMentions.getMentions(), null, null, null, storeState.getCommandOptionAutocompleteItems(), inputCommandContext, autocompleteInputModel.getApplicationCommands(), commandOptions, mapFindOptionRanges, autocompleteCommandUtils.getInputValidity(selectedCommand, commandOptions, this.commandAttachments, chatInputMentionsMapMapInputToMentions), 56, null);
        } else {
            verifiedMessageInputModel = new MentionInputModel.VerifiedMessageInputModel(autocompleteInputModel.getInput(), autocompleteInputModel.getAutocompletables(), chatInputMentionsMapMapInputToMentions.getMentions());
        }
        if (verifiedMessageInputModel instanceof MentionInputModel.VerifiedCommandInputModel) {
            InputEditTextAction inputEditTextActionAppendTextForCommandForInput = autocompleteCommandUtils.appendTextForCommandForInput((MentionInputModel.VerifiedCommandInputModel) verifiedMessageInputModel);
            if (inputEditTextActionAppendTextForCommandForInput instanceof InputEditTextAction.InsertText) {
                return inputEditTextActionAppendTextForCommandForInput;
            }
        }
        InputEditTextAction clearSpans = ((inputState.getCurrentInput().length() == 0) || m.areEqual(inputState.getCurrentInput().toString(), COMMAND_DISCOVER_TOKEN)) ? new InputEditTextAction.ClearSpans(inputState.getCurrentInput()) : generateSpanUpdates(verifiedMessageInputModel);
        this.inputMentionModelSubject.onNext(verifiedMessageInputModel);
        this.inputState = InputState.copy$default(inputState, null, inputCommandContext.getSelectedCommand(), null, null, chatInputMentionsMapMapInputToMentions.getMentions(), 13, null);
        return clearSpans;
    }

    @MainThread
    public final InputEditTextAction onInputTextChanged(CharSequence input, int start, int before, int count) {
        Channel channel;
        m.checkNotNullParameter(input, "input");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<IntRange, Autocompletable> entry : this.inputState.getInputAutocompleteMap().entrySet()) {
            if (input.length() < entry.getKey().getLast() || !entry.getValue().matchesText(input.subSequence(entry.getKey().getFirst(), entry.getKey().getLast()).toString())) {
                IntRange intRangeShiftOrRemove = AutocompleteModelUtils.INSTANCE.shiftOrRemove(entry.getKey(), start, before, count);
                if (intRangeShiftOrRemove != null) {
                    linkedHashMap.put(intRangeShiftOrRemove, entry.getValue());
                }
            } else {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.inputState = InputState.copy$default(this.inputState, null, null, null, null, linkedHashMap, 15, null);
        InputEditTextAction inputEditTextActionOnPreAutocompleteCompute = onPreAutocompleteCompute(input);
        if (!(inputEditTextActionOnPreAutocompleteCompute instanceof InputEditTextAction.None)) {
            return inputEditTextActionOnPreAutocompleteCompute;
        }
        StoreState storeState = this.storeState;
        if (storeState != null && (channel = storeState.getChannel()) != null) {
            checkForCommandsToQuery(input, this.inputState.getCurrentInput(), channel);
        }
        InputState inputState = this.inputState;
        SpannableString spannableStringValueOf = SpannableString.valueOf(input.toString());
        m.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return onDataUpdated(InputState.copy$default(inputState, spannableStringValueOf, null, null, null, null, 30, null), this.storeState);
    }

    public final void onSelectionChanged(String input, int start, int finish) {
        m.checkNotNullParameter(input, "input");
        this.inputSelectionSubject.onNext(new SelectionState(input, new IntRange(start, finish)));
    }

    public final MessageContent replaceAutocompletableDataWithServerValues(String content) {
        MentionInputModel inputModel;
        Map<IntRange, Autocompletable> inputMentionsMap;
        m.checkNotNullParameter(content, "content");
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        if (inputSelectionModel == null || (inputModel = inputSelectionModel.getInputModel()) == null || (inputMentionsMap = inputModel.getInputMentionsMap()) == null) {
            return new MessageContent(content, n.emptyList());
        }
        String strReplaceAutocompleteDataWithServerValues = AutocompleteExtensionsKt.replaceAutocompleteDataWithServerValues(content, inputMentionsMap);
        List listFilterIsInstance = t.filterIsInstance(inputMentionsMap.values(), UserAutocompletable.class);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listFilterIsInstance, 10));
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            arrayList.add(((UserAutocompletable) it.next()).getUser());
        }
        int length = strReplaceAutocompleteDataWithServerValues.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = m.compare(strReplaceAutocompleteDataWithServerValues.charAt(!z2 ? i : length), 32) <= 0;
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
        return new MessageContent(strReplaceAutocompleteDataWithServerValues.subSequence(i, length + 1).toString(), arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.CharSequence] */
    @MainThread
    public final void selectAutocompleteItem(Autocompletable autocompletable) {
        MentionToken autocompleteToken;
        InputSelectionModel inputSelectionModel;
        MentionInputModel inputModel;
        ?? input;
        IntRange value;
        MentionInputModel inputModel2;
        CharSequence input2;
        m.checkNotNullParameter(autocompletable, "autocompletable");
        String str = "";
        if (autocompletable instanceof ApplicationCommandAutocompletable) {
            StringBuilder sb = new StringBuilder();
            sb.append(autocompletable.leadingIdentifier().getIdentifier());
            ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) autocompletable;
            sb.append(applicationCommandAutocompletable.getCommand().getName());
            sb.append(' ');
            String string = sb.toString();
            this.inputState = InputState.copy$default(this.inputState, null, applicationCommandAutocompletable.getCommand(), null, null, null, 29, null);
            BehaviorSubject<InputEditTextAction> behaviorSubject = this.editTextAction;
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            behaviorSubject.onNext(new InputEditTextAction.ReplaceText((inputSelectionModel2 == null || (inputModel2 = inputSelectionModel2.getInputModel()) == null || (input2 = inputModel2.getInput()) == null) ? "" : input2, string, 0, 4, null));
            return;
        }
        InputSelectionModel inputSelectionModel3 = this.lastChatInputModel;
        if (!(inputSelectionModel3 instanceof InputSelectionModel.CommandInputSelectionModel)) {
            if ((inputSelectionModel3 instanceof InputSelectionModel.MessageInputSelectionModel) || inputSelectionModel3 == null) {
                AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
                if (autocompleteInputSelectionModel != null && (inputSelectionModel = autocompleteInputSelectionModel.getInputSelectionModel()) != null && (inputModel = inputSelectionModel.getInputModel()) != null && (input = inputModel.getInput()) != 0) {
                    str = input;
                }
                AutocompleteInputSelectionModel autocompleteInputSelectionModel2 = this.lastAutocompleteInputSelectionModel;
                autocompleteToken = autocompleteInputSelectionModel2 != null ? autocompleteInputSelectionModel2.getAutocompleteToken() : null;
                if (!autocompletable.getInputTextMatchers().isEmpty()) {
                    IntRange intRange = autocompleteToken != null ? new IntRange(autocompleteToken.getStartIndex(), autocompleteToken.getToken().length() + autocompleteToken.getStartIndex()) : new IntRange(str.length(), str.length());
                    String str2 = (String) u.first((List) autocompletable.getInputTextMatchers());
                    String str3 = str2 + ' ';
                    InputState inputState = this.inputState;
                    Map mutableMap = h0.toMutableMap(inputState.getInputAutocompleteMap());
                    mutableMap.put(new IntRange(intRange.getFirst(), str2.length() + intRange.getFirst()), autocompletable);
                    this.inputState = InputState.copy$default(inputState, null, null, null, null, mutableMap, 15, null);
                    this.editTextAction.onNext(new InputEditTextAction.InsertText(str, str3, intRange, str3.length() + intRange.getFirst()));
                    return;
                }
                return;
            }
            return;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel3;
        commandInputSelectionModel.getInputModel().getInputCommandContext().getSelectedCommand();
        ApplicationCommandOption selectedCommandOption = commandInputSelectionModel.getSelectedCommandOption();
        OptionRange optionRange = commandInputSelectionModel.getInputModel().getInputCommandOptionsRanges().get(selectedCommandOption);
        if (!(!autocompletable.getInputTextMatchers().isEmpty()) || selectedCommandOption == null || optionRange == null) {
            return;
        }
        String str4 = (String) u.first((List) autocompletable.getInputTextMatchers());
        String str5 = str4 + ' ';
        IntRange selection = inputSelectionModel3.getSelection();
        if (InputSelectionModelKt.hasSelectedFreeformInput(inputSelectionModel3)) {
            AutocompleteInputSelectionModel autocompleteInputSelectionModel3 = this.lastAutocompleteInputSelectionModel;
            autocompleteToken = autocompleteInputSelectionModel3 != null ? autocompleteInputSelectionModel3.getAutocompleteToken() : null;
            value = new IntRange(autocompleteToken != null ? autocompleteToken.getStartIndex() : selection.getFirst() - 1, selection.getLast());
        } else {
            value = optionRange.getValue();
        }
        InputState inputState2 = this.inputState;
        Map mutableMap2 = h0.toMutableMap(inputState2.getInputAutocompleteMap());
        mutableMap2.put(new IntRange(optionRange.getValue().getFirst(), str4.length() + optionRange.getValue().getFirst()), autocompletable);
        this.inputState = InputState.copy$default(inputState2, null, null, null, null, mutableMap2, 15, null);
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel2 = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel3;
        this.editTextAction.onNext(new InputEditTextAction.InsertText(commandInputSelectionModel2.getInputModel().getInput(), str5, value, (str5.length() + commandInputSelectionModel2.getInputModel().getInput().length()) - (value.getLast() - value.getFirst())));
    }

    public final void selectCommandBrowserApplication(Application application) {
        Integer num;
        m.checkNotNullParameter(application, "application");
        StoreState storeState = this.storeState;
        if ((storeState != null ? storeState.getBrowserCommands() : null) == null || (num = this.inputState.getApplicationsPosition().get(Long.valueOf(application.getId()))) == null || !StoreStream.INSTANCE.getApplicationCommands().hasFetchedApplicationCommands(application.getId())) {
            StoreStream.INSTANCE.getApplicationCommands().requestDiscoverCommands(application.getId());
        } else {
            this.events.onNext(new Event.ScrollAutocompletablesToApplication(application.getId(), num.intValue()));
        }
        StoreStream.INSTANCE.getAnalytics().trackApplicationCommandBrowserJump(application.getId());
    }

    @MainThread
    public final void selectCommandOption(ApplicationCommandOption applicationCommandsOption) {
        InputEditTextAction inputEditTextActionAppendParam$default;
        Attachment<?> attachment;
        m.checkNotNullParameter(applicationCommandsOption, "applicationCommandsOption");
        InputSelectionModel inputSelectionModel = this.lastChatInputModel;
        if (!(inputSelectionModel instanceof InputSelectionModel.CommandInputSelectionModel)) {
            boolean z2 = inputSelectionModel instanceof InputSelectionModel.MessageInputSelectionModel;
            return;
        }
        if (applicationCommandsOption.getType() == ApplicationCommandType.ATTACHMENT && (attachment = this.commandAttachments.get(applicationCommandsOption)) != null) {
            this.selectedOptionForAttachment = applicationCommandsOption;
            this.events.onNext(new Event.PreviewAttachment(attachment));
            return;
        }
        InputSelectionModel.CommandInputSelectionModel commandInputSelectionModel = (InputSelectionModel.CommandInputSelectionModel) inputSelectionModel;
        OptionRange optionRange = commandInputSelectionModel.getInputModel().getInputCommandOptionsRanges().get(applicationCommandsOption);
        IntRange value = optionRange != null ? optionRange.getValue() : null;
        if (value != null) {
            int iOrdinal = applicationCommandsOption.getType().ordinal();
            int i = 1;
            if (iOrdinal != 5 && iOrdinal != 6 && iOrdinal != 7 && iOrdinal != 8) {
                i = 0;
            }
            inputEditTextActionAppendParam$default = new InputEditTextAction.SelectText(commandInputSelectionModel.getInputModel().getInput(), new IntRange(value.getFirst() + i, value.getLast() + (value.getLast() != commandInputSelectionModel.getInputModel().getInput().length() ? -1 : 0)));
        } else {
            inputEditTextActionAppendParam$default = AutocompleteCommandUtils.appendParam$default(AutocompleteCommandUtils.INSTANCE, commandInputSelectionModel.getInputModel().getInput(), applicationCommandsOption, null, 4, null);
        }
        this.editTextAction.onNext(inputEditTextActionAppendParam$default);
    }

    @MainThread
    public final void selectStickerItem(Sticker sticker) {
        String strReplaceAfterLast$default;
        m.checkNotNullParameter(sticker, "sticker");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
        String string = this.inputState.getCurrentInput().toString();
        if (string.length() <= 1 || y.last(string) != ':') {
            strReplaceAfterLast$default = w.replaceAfterLast$default(string, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, "", null, 4, null);
        } else {
            String strSubstring = string.substring(0, w.getLastIndex(string));
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            strReplaceAfterLast$default = w.replaceAfterLast$default(strSubstring, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, "", null, 4, null);
        }
        String strSubstring2 = strReplaceAfterLast$default.substring(0, f.coerceAtLeast(strReplaceAfterLast$default.length() - 1, 0));
        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        this.editTextAction.onNext(new InputEditTextAction.ReplaceText(string, strSubstring2, strSubstring2.length()));
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = this.lastAutocompleteInputSelectionModel;
        if (autocompleteInputSelectionModel != null) {
            companion.getAnalytics().trackAutocompleteSelect(companion.getChannelsSelected().getId(), autocompleteInputSelectionModel.getAutocompleteType(), autocompleteInputSelectionModel.getEmojiNumCount(), autocompleteInputSelectionModel.getStickerNumCount(), AutocompleteSelectionTypes.STICKER, "sticker", Long.valueOf(sticker.getId()));
        }
        companion.getStickers().onStickerUsed(sticker);
    }

    public final void setAttachment(Attachment<?> attachment) {
        CharSequence input;
        MentionInputModel inputModel;
        m.checkNotNullParameter(attachment, "attachment");
        ApplicationCommandOption applicationCommandOption = this.selectedOptionForAttachment;
        if (applicationCommandOption != null) {
            this.commandAttachments.put(applicationCommandOption, attachment);
            InputSelectionModel inputSelectionModel = this.lastChatInputModel;
            if (inputSelectionModel == null || (inputModel = inputSelectionModel.getInputModel()) == null || (input = inputModel.getInput()) == null) {
                input = "";
            }
            InputSelectionModel inputSelectionModel2 = this.lastChatInputModel;
            OptionRange optionRange = AutocompleteCommandUtils.INSTANCE.findOptionRanges(input, inputSelectionModel2 != null ? InputSelectionModelKt.getSelectedCommand(inputSelectionModel2) : null, this.commandAttachments).get(applicationCommandOption);
            IntRange intRange = optionRange != null ? new IntRange(optionRange.getParam().getFirst(), optionRange.getValue().getLast()) : new IntRange(input.length(), input.length());
            StringBuilder sbQ = a.Q(' ');
            sbQ.append(applicationCommandOption.getName());
            sbQ.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sbQ.append(attachment.getDisplayName());
            sbQ.append(' ');
            String string = sbQ.toString();
            this.editTextAction.onNext(new InputEditTextAction.InsertText(input, string, intRange, (string.length() + input.length()) - (intRange.getLast() - intRange.getFirst())));
        }
    }

    public final void setInputState(InputState inputState) {
        m.checkNotNullParameter(inputState, "<set-?>");
        this.inputState = inputState;
    }

    public final void setLastJumpedSequenceId(int i) {
        this.lastJumpedSequenceId = i;
    }

    public final void setStoreState(StoreState storeState) {
        this.storeState = storeState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteViewModel(Long l, AppFlexInputViewModel appFlexInputViewModel, StoreApplicationCommands storeApplicationCommands, StoreExperiments storeExperiments, @ColorInt int i, @ColorInt int i2, @ColorInt int i3, Observable<StoreState> observable) {
        super(new ViewState(AutocompleteViewState.Hidden.INSTANCE, SelectedCommandViewState.Hidden.INSTANCE));
        m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(observable, "storeObservable");
        this.channelId = l;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeApplicationCommands = storeApplicationCommands;
        this.storeExperiments = storeExperiments;
        this.defaultMentionColor = i;
        this.defaultCommandOptionBackgroundColor = i2;
        this.commandOptionErrorColor = i3;
        this.emojiAutocompleteUpsellEnabled = EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled();
        this.logEmojiAutocompleteUpsellViewed = true;
        BehaviorSubject<MentionInputModel> behaviorSubjectK0 = BehaviorSubject.k0();
        this.inputMentionModelSubject = behaviorSubjectK0;
        BehaviorSubject<AutocompleteInputSelectionModel> behaviorSubjectK02 = BehaviorSubject.k0();
        this.autocompleteInputSelectionModelSubject = behaviorSubjectK02;
        BehaviorSubject<SelectionState> behaviorSubjectK03 = BehaviorSubject.k0();
        this.inputSelectionSubject = behaviorSubjectK03;
        this.editTextAction = BehaviorSubject.k0();
        this.events = BehaviorSubject.k0();
        this.commandAttachments = new LinkedHashMap();
        this.inputState = new InputState(null, null, null, null, null, 31, null);
        Observable observableT = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).t(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableT, "storeObservable\n        …ore Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        Observable<SelectionState> observableR = behaviorSubjectK03.r();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "inputMentionModelSubject");
        Observable observableJ = Observable.j(observableR, ObservableExtensionsKt.computationLatest(behaviorSubjectK0), new AnonymousClass3());
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…inputModel)\n      }\n    }");
        ObservableExtensionsKt.AnonymousClass1 anonymousClass1 = ObservableExtensionsKt.AnonymousClass1.INSTANCE;
        Observable observableY = observableJ.y(anonymousClass1);
        ObservableExtensionsKt.AnonymousClass2 anonymousClass2 = ObservableExtensionsKt.AnonymousClass2.INSTANCE;
        Observable observableG = observableY.G(anonymousClass2);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableT2 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null).t(AnonymousClass4.INSTANCE);
        m.checkNotNullExpressionValue(observableT2, "Observable.combineLatest…del Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT2, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(this), 62, (Object) null);
        m.checkNotNullExpressionValue(behaviorSubjectK02, "autocompleteInputSelectionModelSubject");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable observableT3 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(behaviorSubjectK02, 100L, timeUnit)), this, null, 2, null).t(AnonymousClass6.INSTANCE);
        m.checkNotNullExpressionValue(observableT3, "autocompleteInputSelecti…del Error\", it)\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableT3, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass7(this), 62, (Object) null);
        m.checkNotNullExpressionValue(behaviorSubjectK02, "autocompleteInputSelectionModelSubject");
        Observable observableR2 = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(behaviorSubjectK02), this, null, 2, null).t(AnonymousClass8.INSTANCE).G(AnonymousClass9.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR2, "autocompleteInputSelecti…  .distinctUntilChanged()");
        Observable observableG2 = observableR2.y(anonymousClass1).G(anonymousClass2);
        m.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        Observable observableP = observableG2.u(new AnonymousClass10()).p(500L, timeUnit);
        m.checkNotNullExpressionValue(observableP, "autocompleteInputSelecti…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, AutocompleteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass11(), 62, (Object) null);
        Observable observableR3 = behaviorSubjectK02.G(AnonymousClass12.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR3, "autocompleteInputSelecti… }.distinctUntilChanged()");
        StoreGuilds.Actions.requestMembers(this, observableR3, true);
        this.lastJumpedSequenceId = -1;
    }
}

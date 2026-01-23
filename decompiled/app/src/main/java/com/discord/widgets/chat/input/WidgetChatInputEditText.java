package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.chat.input.MessageDraftsRepo;
import com.lytefast.flexinput.widget.FlexEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: WidgetChatInputEditText.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputEditText {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long channelId;
    private final FlexEditText editText;
    private final Subject<Boolean, Boolean> emptyTextSubject;
    private long lastTypingEmissionMillis;
    private final MessageDraftsRepo messageDraftsRepo;
    private Function0<Unit> onSendListener;

    /* JADX INFO: compiled from: WidgetChatInputEditText.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String toStringSafe(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            try {
                return textView.getText().toString();
            } catch (Exception unused) {
                return "";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputEditText$setHardwareKeyboardSendBehavior$1 */
    /* JADX INFO: compiled from: WidgetChatInputEditText.kt */
    public static final class ViewOnKeyListenerC77521 implements View.OnKeyListener {
        public ViewOnKeyListenerC77521() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            Function0<Unit> onSendListener;
            Intrinsics3.checkNotNullParameter(keyEvent, "event");
            boolean z2 = (keyEvent.getFlags() & 2) == 2;
            if ((i == 66) && !z2) {
                boolean zHasModifiers = keyEvent.hasModifiers(1);
                boolean isShiftEnterToSendEnabled = StoreStream.INSTANCE.getUserSettings().getIsShiftEnterToSendEnabled();
                if ((isShiftEnterToSendEnabled && zHasModifiers) || (!isShiftEnterToSendEnabled && !zHasModifiers)) {
                    if (WidgetChatInputEditText.this.getOnSendListener() != null && keyEvent.getAction() == 1 && (onSendListener = WidgetChatInputEditText.this.getOnSendListener()) != null) {
                        onSendListener.invoke();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputEditText$setOnTextChangedListener$1 */
    /* JADX INFO: compiled from: WidgetChatInputEditText.kt */
    public static final class C77531 extends TextWatcher {
        private boolean empty;

        public C77531() {
            super(null, null, null, 7, null);
            this.empty = true;
        }

        @Override // com.discord.utilities.view.text.TextWatcher, android.text.TextWatcher
        public void afterTextChanged(Editable s2) {
            Intrinsics3.checkNotNullParameter(s2, "s");
            super.afterTextChanged(s2);
            WidgetChatInputEditText.this.saveText();
            boolean zIsEmpty = TextUtils.isEmpty(s2);
            if (this.empty != zIsEmpty) {
                this.empty = zIsEmpty;
                WidgetChatInputEditText.access$getEmptyTextSubject$p(WidgetChatInputEditText.this).onNext(Boolean.valueOf(zIsEmpty));
            }
            boolean zStartsWith$default = Strings4.startsWith$default((CharSequence) s2.toString(), MentionUtils.SLASH_CHAR, false, 2, (Object) null);
            if (WidgetChatInputEditText.access$getLastTypingEmissionMillis$p(WidgetChatInputEditText.this) - ClockFactory.get().currentTimeMillis() >= -10000 || zIsEmpty || zStartsWith$default) {
                return;
            }
            WidgetChatInputEditText.access$setLastTypingEmissionMillis$p(WidgetChatInputEditText.this, ClockFactory.get().currentTimeMillis());
            StoreStream.INSTANCE.getUsersTyping().setUserTyping(WidgetChatInputEditText.this.getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputEditText$setSoftwareKeyboardSendBehavior$1 */
    /* JADX INFO: compiled from: WidgetChatInputEditText.kt */
    public static final class C77541 implements TextView.OnEditorActionListener {
        public C77541() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            int i2 = i & 255;
            if (WidgetChatInputEditText.this.getOnSendListener() == null || i2 != 6) {
                return false;
            }
            Function0<Unit> onSendListener = WidgetChatInputEditText.this.getOnSendListener();
            if (onSendListener == null) {
                return true;
            }
            onSendListener.invoke();
            return true;
        }
    }

    public WidgetChatInputEditText(FlexEditText flexEditText, MessageDraftsRepo messageDraftsRepo) {
        Intrinsics3.checkNotNullParameter(flexEditText, "editText");
        Intrinsics3.checkNotNullParameter(messageDraftsRepo, "messageDraftsRepo");
        this.editText = flexEditText;
        this.messageDraftsRepo = messageDraftsRepo;
        BehaviorSubject behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(Boolean.TRUE);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(true)");
        this.emptyTextSubject = behaviorSubjectM11130l0;
        setOnTextChangedListener();
        setSoftwareKeyboardSendBehavior();
        setHardwareKeyboardSendBehavior();
    }

    public static final /* synthetic */ Subject access$getEmptyTextSubject$p(WidgetChatInputEditText widgetChatInputEditText) {
        return widgetChatInputEditText.emptyTextSubject;
    }

    public static final /* synthetic */ long access$getLastTypingEmissionMillis$p(WidgetChatInputEditText widgetChatInputEditText) {
        return widgetChatInputEditText.lastTypingEmissionMillis;
    }

    public static final /* synthetic */ void access$setLastTypingEmissionMillis$p(WidgetChatInputEditText widgetChatInputEditText, long j) {
        widgetChatInputEditText.lastTypingEmissionMillis = j;
    }

    private final void setHardwareKeyboardSendBehavior() {
        this.editText.setOnKeyListener(new ViewOnKeyListenerC77521());
    }

    private final void setOnTextChangedListener() {
        this.editText.addTextChangedListener(new C77531());
    }

    private final void setSoftwareKeyboardSendBehavior() {
        this.editText.setOnEditorActionListener(new C77541());
    }

    public final void clearLastTypingEmission() {
        this.lastTypingEmissionMillis = 0L;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Function0<Unit> getOnSendListener() {
        return this.onSendListener;
    }

    public final String getText() {
        return INSTANCE.toStringSafe(this.editText);
    }

    public final void saveText() {
        this.messageDraftsRepo.setTextChannelInput(this.channelId, this.editText.getText());
    }

    public final void setChannelId(long j) {
        this.channelId = j;
    }

    public final void setOnSendListener(Function0<Unit> function0) {
        this.onSendListener = function0;
    }

    public final void setChannelId(long channelId, boolean saveExistingText) {
        if (saveExistingText) {
            saveText();
        }
        this.channelId = channelId;
    }

    public /* synthetic */ WidgetChatInputEditText(FlexEditText flexEditText, MessageDraftsRepo messageDraftsRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flexEditText, (i & 2) != 0 ? MessageDraftsRepo.Provider.INSTANCE.get() : messageDraftsRepo);
    }
}

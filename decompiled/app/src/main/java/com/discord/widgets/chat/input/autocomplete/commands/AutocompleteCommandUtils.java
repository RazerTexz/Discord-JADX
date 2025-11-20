package com.discord.widgets.chat.input.autocomplete.commands;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.a;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandKt;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.utilities.SnowflakeUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteModelUtils;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import com.discord.widgets.chat.input.models.AttachmentOptionValue;
import com.discord.widgets.chat.input.models.AutocompleteApplicationCommands;
import com.discord.widgets.chat.input.models.BooleanOptionValue;
import com.discord.widgets.chat.input.models.ChannelOptionValue;
import com.discord.widgets.chat.input.models.ChatInputMentionsMap;
import com.discord.widgets.chat.input.models.CommandOptionValue;
import com.discord.widgets.chat.input.models.InputCommandContext;
import com.discord.widgets.chat.input.models.IntegerOptionValue;
import com.discord.widgets.chat.input.models.MentionInputModel;
import com.discord.widgets.chat.input.models.NumberOptionValue;
import com.discord.widgets.chat.input.models.OptionRange;
import com.discord.widgets.chat.input.models.RawOptionValue;
import com.discord.widgets.chat.input.models.RoleOptionValue;
import com.discord.widgets.chat.input.models.SnowflakeOptionValue;
import com.discord.widgets.chat.input.models.StringOptionValue;
import com.discord.widgets.chat.input.models.UserOptionValue;
import com.lytefast.flexinput.model.Attachment;
import d0.g0.e;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: AutocompleteCommandUtils.kt */
/* loaded from: classes2.dex */
public final class AutocompleteCommandUtils {
    public static final AutocompleteCommandUtils INSTANCE = new AutocompleteCommandUtils();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ApplicationCommandType.values();
            int[] iArr = new int[12];
            $EnumSwitchMapping$0 = iArr;
            ApplicationCommandType applicationCommandType = ApplicationCommandType.USER;
            iArr[applicationCommandType.ordinal()] = 1;
            ApplicationCommandType applicationCommandType2 = ApplicationCommandType.CHANNEL;
            iArr[applicationCommandType2.ordinal()] = 2;
            ApplicationCommandType applicationCommandType3 = ApplicationCommandType.ROLE;
            iArr[applicationCommandType3.ordinal()] = 3;
            ApplicationCommandType applicationCommandType4 = ApplicationCommandType.MENTIONABLE;
            iArr[applicationCommandType4.ordinal()] = 4;
            ApplicationCommandType.values();
            int[] iArr2 = new int[12];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ApplicationCommandType.SUBCOMMAND.ordinal()] = 1;
            iArr2[ApplicationCommandType.SUBCOMMAND_GROUP.ordinal()] = 2;
            ApplicationCommandType applicationCommandType5 = ApplicationCommandType.STRING;
            iArr2[applicationCommandType5.ordinal()] = 3;
            ApplicationCommandType applicationCommandType6 = ApplicationCommandType.INTEGER;
            iArr2[applicationCommandType6.ordinal()] = 4;
            ApplicationCommandType applicationCommandType7 = ApplicationCommandType.NUMBER;
            iArr2[applicationCommandType7.ordinal()] = 5;
            ApplicationCommandType applicationCommandType8 = ApplicationCommandType.BOOLEAN;
            iArr2[applicationCommandType8.ordinal()] = 6;
            iArr2[applicationCommandType.ordinal()] = 7;
            iArr2[applicationCommandType2.ordinal()] = 8;
            iArr2[applicationCommandType3.ordinal()] = 9;
            iArr2[applicationCommandType4.ordinal()] = 10;
            iArr2[ApplicationCommandType.UNKNOWN.ordinal()] = 11;
            ApplicationCommandType applicationCommandType9 = ApplicationCommandType.ATTACHMENT;
            iArr2[applicationCommandType9.ordinal()] = 12;
            ApplicationCommandType.values();
            int[] iArr3 = new int[12];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[applicationCommandType5.ordinal()] = 1;
            iArr3[applicationCommandType6.ordinal()] = 2;
            iArr3[applicationCommandType7.ordinal()] = 3;
            iArr3[applicationCommandType8.ordinal()] = 4;
            iArr3[applicationCommandType.ordinal()] = 5;
            iArr3[applicationCommandType2.ordinal()] = 6;
            iArr3[applicationCommandType3.ordinal()] = 7;
            iArr3[applicationCommandType4.ordinal()] = 8;
            iArr3[applicationCommandType9.ordinal()] = 9;
        }
    }

    private AutocompleteCommandUtils() {
    }

    public static /* synthetic */ InputEditTextAction.InsertText appendParam$default(AutocompleteCommandUtils autocompleteCommandUtils, CharSequence charSequence, ApplicationCommandOption applicationCommandOption, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return autocompleteCommandUtils.appendParam(charSequence, applicationCommandOption, num);
    }

    private final Number asSafeNumberOrNull(Number number) {
        if (number == null || !INSTANCE.isSafeNumber(number)) {
            return null;
        }
        return number;
    }

    public static /* synthetic */ InputCommandContext getInputCommandContext$default(AutocompleteCommandUtils autocompleteCommandUtils, CharSequence charSequence, long j, List list, AutocompleteApplicationCommands autocompleteApplicationCommands, ApplicationCommand applicationCommand, int i, Object obj) {
        if ((i & 16) != 0) {
            applicationCommand = null;
        }
        return autocompleteCommandUtils.getInputCommandContext(charSequence, j, list, autocompleteApplicationCommands, applicationCommand);
    }

    private final boolean isSafeNumber(Number number) {
        double dDoubleValue = number.doubleValue();
        return dDoubleValue >= ((double) (-9007199254740991L)) && dDoubleValue <= ((double) 9007199254740991L);
    }

    private final Number parseNumber(String str) {
        if (str == null) {
            return null;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Number number = NumberFormat.getInstance().parse(str, parsePosition);
            if (parsePosition.getIndex() != str.length() || parsePosition.getIndex() == 0) {
                throw new ParseException("Invalid input", parsePosition.getIndex());
            }
            return number;
        } catch (ParseException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputEditTextAction.InsertText appendParam(CharSequence input, ApplicationCommandOption applicationCommandsOption, Integer insertIndex) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(applicationCommandsOption, "applicationCommandsOption");
        input.length();
        String str = "";
        StringBuilder sbU = a.U((w.endsWith$default(input, ' ', false, 2, (Object) null) || insertIndex != null) ? "" : " ");
        sbU.append(applicationCommandsOption.getName());
        sbU.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        String string = sbU.toString();
        int iOrdinal = applicationCommandsOption.getType().ordinal();
        if (iOrdinal == 5) {
            str = "@";
        } else if (iOrdinal == 6) {
            str = "#";
        } else if (iOrdinal == 7 || iOrdinal == 8) {
        }
        String strW = a.w(string, str);
        int iIntValue = insertIndex != null ? insertIndex.intValue() : input.length();
        return new InputEditTextAction.InsertText(input, strW, new IntRange(iIntValue, iIntValue), strW.length() + input.length());
    }

    @MainThread
    public final InputEditTextAction appendTextForCommandForInput(MentionInputModel.VerifiedCommandInputModel model) {
        m.checkNotNullParameter(model, "model");
        ApplicationCommand selectedCommand = model.getInputCommandContext().getSelectedCommand();
        if (selectedCommand != null && selectedCommand.getOptions().size() == 1) {
            ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) u.first((List) selectedCommand.getOptions());
            StringBuilder sbQ = a.Q(MentionUtilsKt.SLASH_CHAR);
            sbQ.append(selectedCommand.getName());
            sbQ.append(' ');
            String string = sbQ.toString();
            if (!model.getInputCommandOptionsRanges().containsKey(applicationCommandOption) && model.getInput().length() > string.length() && applicationCommandOption.getType() != ApplicationCommandType.ATTACHMENT) {
                return appendParam(model.getInput(), applicationCommandOption, Integer.valueOf(string.length()));
            }
        }
        return new InputEditTextAction.None(model.getInput());
    }

    public final Map<ApplicationCommandOption, OptionRange> findOptionRanges(CharSequence charSequence, ApplicationCommand applicationCommand, Map<ApplicationCommandOption, ? extends Attachment<?>> map) {
        List<ApplicationCommandOption> options;
        IntRange intRangeFindValueRange;
        m.checkNotNullParameter(charSequence, "$this$findOptionRanges");
        m.checkNotNullParameter(map, "attachments");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (applicationCommand != null && (options = applicationCommand.getOptions()) != null) {
            for (ApplicationCommandOption applicationCommandOption : options) {
                AutocompleteCommandUtils autocompleteCommandUtils = INSTANCE;
                Integer numFindStartOfParam = autocompleteCommandUtils.findStartOfParam(charSequence, applicationCommandOption.getName());
                if (numFindStartOfParam != null && (intRangeFindValueRange = autocompleteCommandUtils.findValueRange(charSequence, applicationCommand, applicationCommandOption.getName())) != null) {
                    Attachment<?> attachment = map.get(applicationCommandOption);
                    String displayName = attachment != null ? attachment.getDisplayName() : null;
                }
            }
        }
        return linkedHashMap;
    }

    @VisibleForTesting
    public final Integer findStartOfParam(CharSequence charSequence, String str) {
        IntRange range;
        m.checkNotNullParameter(charSequence, "$this$findStartOfParam");
        m.checkNotNullParameter(str, "paramName");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("[\\s|\\n]" + str + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR), charSequence, 0, 2, null);
        int first = (matchResultFind$default == null || (range = matchResultFind$default.getRange()) == null) ? -1 : range.getFirst();
        if (first == -1) {
            return null;
        }
        return Integer.valueOf(first + 1);
    }

    @VisibleForTesting
    public final Integer findStartOfValue(CharSequence charSequence, String str) {
        m.checkNotNullParameter(charSequence, "$this$findStartOfValue");
        m.checkNotNullParameter(str, "paramName");
        Integer numFindStartOfParam = findStartOfParam(charSequence, str);
        int iIntValue = numFindStartOfParam != null ? numFindStartOfParam.intValue() : -1;
        if (iIntValue != -1) {
            return Integer.valueOf(str.length() + iIntValue + 1);
        }
        return null;
    }

    public final IntRange findValueRange(CharSequence charSequence, ApplicationCommand applicationCommand, String str) {
        int first;
        e next;
        IntRange range;
        ApplicationCommandOption applicationCommandOption;
        List<ApplicationCommandOption> options;
        Object next2;
        m.checkNotNullParameter(charSequence, "$this$findValueRange");
        m.checkNotNullParameter(str, "paramName");
        Integer numFindStartOfValue = findStartOfValue(charSequence, str);
        if (numFindStartOfValue == null) {
            return null;
        }
        int iIntValue = numFindStartOfValue.intValue();
        Iterator it = Regex.findAll$default(new Regex(" ([\\p{L}0-9-_]*):"), charSequence.subSequence(iIntValue, charSequence.length()).toString(), 0, 2, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                first = -1;
                break;
            }
            Iterator<e> it2 = ((MatchResult) it.next()).getGroups().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                e eVar = next;
                if (applicationCommand == null || (options = applicationCommand.getOptions()) == null) {
                    applicationCommandOption = null;
                } else {
                    Iterator<T> it3 = options.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                        if (m.areEqual(eVar != null ? eVar.getValue() : null, ((ApplicationCommandOption) next2).getName())) {
                            break;
                        }
                    }
                    applicationCommandOption = (ApplicationCommandOption) next2;
                }
                if (applicationCommandOption != null) {
                    break;
                }
            }
            e eVar2 = next;
            first = (eVar2 == null || (range = eVar2.getRange()) == null) ? -1 : range.getFirst();
            if (first != -1) {
                break;
            }
        }
        return first == -1 ? new IntRange(iIntValue, charSequence.length()) : new IntRange(iIntValue, first + iIntValue);
    }

    public final String getCommandPrefix(CharSequence charSequence) {
        List<String> groupValues;
        m.checkNotNullParameter(charSequence, "$this$getCommandPrefix");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("^(/([\\p{L}0-9-_]+\\s*){0,3})"), charSequence, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) u.getOrNull(groupValues, 1);
    }

    public final Set<ApplicationCommandOption> getErrorsToShowForCommandParameters(ApplicationCommand selectedCommand, ApplicationCommandOption selectedCommandOption, ApplicationCommandOption previouslySelected, Map<ApplicationCommandOption, Boolean> validMap, Map<ApplicationCommandOption, ? extends CommandOptionValue> parsedCommandOptions) {
        m.checkNotNullParameter(validMap, "validMap");
        m.checkNotNullParameter(parsedCommandOptions, "parsedCommandOptions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (selectedCommand == null) {
            return n0.emptySet();
        }
        for (ApplicationCommandOption applicationCommandOption : selectedCommand.getOptions()) {
            if (parsedCommandOptions.containsKey(applicationCommandOption)) {
                CommandOptionValue commandOptionValue = parsedCommandOptions.get(applicationCommandOption);
                String strValueOf = String.valueOf(commandOptionValue != null ? commandOptionValue.getValue() : null);
                boolean z2 = false;
                boolean z3 = t.isBlank(strValueOf) || (strValueOf.length() == 1 && MentionUtilsKt.getDEFAULT_LEADING_IDENTIFIERS().contains(Character.valueOf(strValueOf.charAt(0))));
                boolean zAreEqual = m.areEqual(selectedCommandOption, applicationCommandOption);
                boolean z4 = previouslySelected != null && m.areEqual(previouslySelected, applicationCommandOption);
                boolean zContainsKey = parsedCommandOptions.containsKey(applicationCommandOption);
                boolean z5 = (zAreEqual && z4) || (zAreEqual && z3);
                if (m.areEqual(validMap.get(applicationCommandOption), Boolean.FALSE) && !z5 && zContainsKey) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashSet.add(applicationCommandOption);
                }
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01c9 A[EDGE_INSN: B:101:0x01c9->B:97:0x01c9 BREAK  A[LOOP:0: B:87:0x01a8->B:105:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputCommandContext getInputCommandContext(CharSequence input, long userId, List<Long> userRoles, AutocompleteApplicationCommands applicationCommands, ApplicationCommand selectedCommand) {
        ApplicationCommand applicationCommand;
        ApplicationCommand applicationCommand2;
        ApplicationCommand applicationCommand3;
        Iterator it;
        long j = userId;
        List<Long> list = userRoles;
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(list, "userRoles");
        m.checkNotNullParameter(applicationCommands, "applicationCommands");
        String commandPrefix = getCommandPrefix(input);
        Application application = null;
        Object obj = null;
        if (commandPrefix == null) {
            applicationCommand = null;
        } else if (selectedCommand != null) {
            String strSubstring = commandPrefix.substring(1);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            StringBuilder sb = new StringBuilder();
            String name = selectedCommand.getName();
            if (name == null) {
                name = "";
            }
            if (!t.startsWith$default(strSubstring, a.J(sb, name, " "), false, 2, null)) {
                m.checkNotNullExpressionValue(commandPrefix.substring(1), "(this as java.lang.String).substring(startIndex)");
                if (!m.areEqual(r12, selectedCommand.getName() != null ? r13 : "")) {
                    if (commandPrefix.length() > 0) {
                        List<ApplicationCommand> listFlattenSubCommands = StoreApplicationCommandsKt.flattenSubCommands(applicationCommands.getQueryCommands());
                        String strSubstring2 = commandPrefix.substring(1);
                        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : listFlattenSubCommands) {
                            ApplicationCommand applicationCommand4 = (ApplicationCommand) obj2;
                            if (ApplicationCommandKt.hasPermission(applicationCommand4, j, list) && (t.startsWith$default(applicationCommand4.getName(), strSubstring2, false, 2, null) && (m.areEqual(strSubstring2, applicationCommand4.getName()) ^ true))) {
                                arrayList.add(obj2);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int length = 0;
                        boolean z2 = false;
                        for (Object obj3 : listFlattenSubCommands) {
                            ApplicationCommand applicationCommand5 = (ApplicationCommand) obj3;
                            boolean zHasPermission = ApplicationCommandKt.hasPermission(applicationCommand5, j, list);
                            boolean zAreEqual = m.areEqual(strSubstring2, applicationCommand5.getName());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(applicationCommand5.getName());
                            sb2.append(" ");
                            boolean z3 = zHasPermission && (t.startsWith$default(strSubstring2, sb2.toString(), false, 2, null) || zAreEqual);
                            if (z3 && applicationCommand5.getName().length() == length) {
                                z2 = true;
                            } else if (z3 && applicationCommand5.getName().length() > length) {
                                length = applicationCommand5.getName().length();
                                z2 = false;
                            }
                            if (z3) {
                                arrayList2.add(obj3);
                            }
                            j = userId;
                            list = userRoles;
                        }
                        Iterator it2 = arrayList2.iterator();
                        if (it2.hasNext()) {
                            ?? next = it2.next();
                            if (it2.hasNext()) {
                                String name2 = ((ApplicationCommand) next).getName();
                                do {
                                    Object next2 = it2.next();
                                    String name3 = ((ApplicationCommand) next2).getName();
                                    next = next;
                                    if (name2.compareTo(name3) < 0) {
                                        next = next2;
                                        name2 = name3;
                                    }
                                } while (it2.hasNext());
                            }
                            applicationCommand2 = next;
                        } else {
                            applicationCommand2 = null;
                        }
                        applicationCommand = applicationCommand2;
                        if (arrayList.isEmpty()) {
                            if (z2) {
                                obj = null;
                                applicationCommand3 = t.startsWith$default(input.subSequence(1, input.length()).toString(), m.stringPlus(applicationCommand != null ? applicationCommand.getName() : null, " "), false, 2, null) ? null : null;
                            } else {
                                obj = null;
                            }
                        }
                        applicationCommand = applicationCommand3;
                        obj = applicationCommand;
                    }
                    it = applicationCommands.getApplications().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            break;
                        }
                        Object next3 = it.next();
                        if (applicationCommand != null && ((Application) next3).getId() == applicationCommand.getApplicationId()) {
                            obj = next3;
                            break;
                        }
                    }
                    application = (Application) obj;
                }
            }
            applicationCommand = selectedCommand;
            it = applicationCommands.getApplications().iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            application = (Application) obj;
        }
        return new InputCommandContext(application, applicationCommand);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<ApplicationCommandOption, Boolean> getInputValidity(ApplicationCommand selectedCommand, Map<ApplicationCommandOption, ? extends CommandOptionValue> parsedCommandOptions, Map<ApplicationCommandOption, ? extends Attachment<?>> commandOptionAttachments, ChatInputMentionsMap inputMentionsMap) {
        Object next;
        m.checkNotNullParameter(selectedCommand, "selectedCommand");
        m.checkNotNullParameter(parsedCommandOptions, "parsedCommandOptions");
        m.checkNotNullParameter(commandOptionAttachments, "commandOptionAttachments");
        m.checkNotNullParameter(inputMentionsMap, "inputMentionsMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ApplicationCommandOption applicationCommandOption : selectedCommand.getOptions()) {
            if (applicationCommandOption.getType() == ApplicationCommandType.ATTACHMENT) {
                boolean zContainsKey = commandOptionAttachments.containsKey(applicationCommandOption);
                if (zContainsKey || applicationCommandOption.getRequired()) {
                    linkedHashMap.put(applicationCommandOption, Boolean.valueOf(zContainsKey));
                }
            } else {
                CommandOptionValue commandOptionValue = parsedCommandOptions.get(applicationCommandOption);
                if (commandOptionValue != null) {
                    boolean z2 = false;
                    if (applicationCommandOption.getChoices() != null && (!r3.isEmpty())) {
                        List<CommandChoice> choices = applicationCommandOption.getChoices();
                        if (!(choices instanceof Collection) || !choices.isEmpty()) {
                            Iterator<T> it = choices.iterator();
                            while (it.hasNext()) {
                                if (m.areEqual(((CommandChoice) it.next()).getValue(), commandOptionValue.getValue().toString())) {
                                    z2 = true;
                                }
                            }
                        }
                        linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                    } else if (applicationCommandOption.getAutocomplete()) {
                        Iterator it2 = d0.t.t.filterIsInstance(inputMentionsMap.getMentions().values(), ApplicationCommandChoiceAutocompletable.class).iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                if (m.areEqual(((ApplicationCommandChoiceAutocompletable) next).getOptionName(), applicationCommandOption.getName())) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        if (((ApplicationCommandChoiceAutocompletable) next) != null) {
                            z2 = true;
                        }
                        linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                    } else {
                        switch (applicationCommandOption.getType()) {
                            case SUBCOMMAND:
                            case SUBCOMMAND_GROUP:
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case STRING:
                                if ((commandOptionValue instanceof StringOptionValue) && (!t.isBlank(commandOptionValue.getValue().toString()))) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case INTEGER:
                                if (commandOptionValue instanceof IntegerOptionValue) {
                                    if (applicationCommandOption.getMinValue() != null) {
                                        long jLongValue = applicationCommandOption.getMinValue().longValue();
                                        Object value = commandOptionValue.getValue();
                                        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                                        if (jLongValue <= ((Long) value).longValue()) {
                                            if (applicationCommandOption.getMaxValue() != null) {
                                                long jLongValue2 = applicationCommandOption.getMaxValue().longValue();
                                                Object value2 = commandOptionValue.getValue();
                                                Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Long");
                                                if (jLongValue2 >= ((Long) value2).longValue()) {
                                                }
                                            }
                                        }
                                    }
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case BOOLEAN:
                                z2 = commandOptionValue instanceof BooleanOptionValue;
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case USER:
                                if ((commandOptionValue instanceof UserOptionValue) || (commandOptionValue instanceof SnowflakeOptionValue)) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case CHANNEL:
                                if (!(commandOptionValue instanceof ChannelOptionValue)) {
                                    if (commandOptionValue instanceof SnowflakeOptionValue) {
                                    }
                                    linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                    break;
                                } else {
                                    List<Integer> channelTypes = applicationCommandOption.getChannelTypes();
                                    if ((channelTypes == null || channelTypes.isEmpty()) || applicationCommandOption.getChannelTypes().contains(Integer.valueOf(((ChannelOptionValue) commandOptionValue).getChannel().getType()))) {
                                    }
                                }
                                break;
                            case ROLE:
                                if ((commandOptionValue instanceof RoleOptionValue) || (commandOptionValue instanceof SnowflakeOptionValue)) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case MENTIONABLE:
                                if ((commandOptionValue instanceof UserOptionValue) || (commandOptionValue instanceof RoleOptionValue) || (commandOptionValue instanceof SnowflakeOptionValue)) {
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case NUMBER:
                                if (commandOptionValue instanceof NumberOptionValue) {
                                    if (applicationCommandOption.getMinValue() != null) {
                                        double dDoubleValue = applicationCommandOption.getMinValue().doubleValue();
                                        Object value3 = commandOptionValue.getValue();
                                        Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Number");
                                        if (dDoubleValue <= ((Number) value3).doubleValue()) {
                                            if (applicationCommandOption.getMaxValue() != null) {
                                                double dDoubleValue2 = applicationCommandOption.getMaxValue().doubleValue();
                                                Object value4 = commandOptionValue.getValue();
                                                Objects.requireNonNull(value4, "null cannot be cast to non-null type kotlin.Number");
                                                if (dDoubleValue2 >= ((Number) value4).doubleValue()) {
                                                }
                                            }
                                        }
                                    }
                                }
                                linkedHashMap.put(applicationCommandOption, Boolean.valueOf(z2));
                                break;
                            case ATTACHMENT:
                            case UNKNOWN:
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    }
                } else if (applicationCommandOption.getRequired()) {
                    linkedHashMap.put(applicationCommandOption, Boolean.FALSE);
                }
            }
        }
        return linkedHashMap;
    }

    public final ApplicationCommand getSelectedCommand(List<? extends ApplicationCommand> commands, String prefix, String input, long userId, List<Long> roles) {
        m.checkNotNullParameter(commands, "commands");
        m.checkNotNullParameter(prefix, "prefix");
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(roles, "roles");
        Object obj = null;
        if (!(prefix.length() > 0)) {
            return null;
        }
        Iterator<T> it = commands.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ApplicationCommand applicationCommand = (ApplicationCommand) next;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(MentionUtilsKt.SLASH_CHAR) + applicationCommand.getName());
            sb.append(' ');
            if (t.startsWith$default(input, sb.toString(), false, 2, null) && ApplicationCommandKt.hasPermission(applicationCommand, userId, roles)) {
                obj = next;
                break;
            }
        }
        return (ApplicationCommand) obj;
    }

    public final ApplicationCommandOption getSelectedCommandOption(int cursorPosition, Map<ApplicationCommandOption, OptionRange> optionRanges) {
        Set<ApplicationCommandOption> setKeySet;
        if (optionRanges == null || (setKeySet = optionRanges.keySet()) == null) {
            return null;
        }
        for (ApplicationCommandOption applicationCommandOption : setKeySet) {
            OptionRange optionRange = optionRanges.get(applicationCommandOption);
            if (optionRange != null && optionRange.getParam().getFirst() < cursorPosition && optionRange.getValue().getLast() >= cursorPosition && applicationCommandOption.getType() != ApplicationCommandType.ATTACHMENT) {
                return applicationCommandOption;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<ApplicationCommandOption, CommandOptionValue> parseCommandOptions(CharSequence input, ApplicationCommand command, ChatInputMentionsMap mentionMap, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments) {
        CommandOptionValue stringOptionValue;
        Object next;
        String value;
        Object next2;
        CommandOptionValue integerOptionValue;
        CommandOptionValue numberOptionValue;
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(command, "command");
        m.checkNotNullParameter(mentionMap, "mentionMap");
        m.checkNotNullParameter(attachments, "attachments");
        Map<ApplicationCommandOption, OptionRange> mapFindOptionRanges = findOptionRanges(input, command, attachments);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<ApplicationCommandOption, OptionRange> entry : mapFindOptionRanges.entrySet()) {
            ApplicationCommandOption key = entry.getKey();
            OptionRange value2 = entry.getValue();
            String string = input.subSequence(value2.getValue().getFirst(), value2.getValue().getLast()).toString();
            Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
            String string2 = w.trim(string).toString();
            Iterator<T> it = mentionMap.getMentions().values().iterator();
            while (true) {
                stringOptionValue = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (((Autocompletable) next).matchesText(string2)) {
                    }
                } else {
                    next = null;
                }
            }
            Autocompletable autocompletable = (Autocompletable) next;
            if (key.getAutocomplete() && (autocompletable instanceof ApplicationCommandChoiceAutocompletable)) {
                value = ((ApplicationCommandChoiceAutocompletable) autocompletable).getChoice().getValue();
            } else {
                List<CommandChoice> choices = key.getChoices();
                if (choices != null) {
                    Iterator<T> it2 = choices.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            next2 = it2.next();
                            String name = ((CommandChoice) next2).getName();
                            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
                            if (m.areEqual(w.trim(name).toString(), string2)) {
                            }
                        } else {
                            next2 = null;
                        }
                    }
                    CommandChoice commandChoice = (CommandChoice) next2;
                    if (commandChoice == null || (value = commandChoice.getValue()) == null) {
                        value = string2;
                    }
                }
            }
            switch (key.getType().ordinal()) {
                case 2:
                    stringOptionValue = new StringOptionValue(value);
                    break;
                case 3:
                    Long lAsSafeNumberOrNull = asSafeNumberOrNull(s.toLongOrNull(value));
                    if (lAsSafeNumberOrNull != null) {
                        integerOptionValue = new IntegerOptionValue(lAsSafeNumberOrNull.longValue());
                        stringOptionValue = integerOptionValue;
                    }
                    break;
                case 4:
                    if (AutocompleteModelUtils.INSTANCE.isBoolean(value)) {
                        numberOptionValue = new BooleanOptionValue(Boolean.parseBoolean(value));
                        stringOptionValue = numberOptionValue;
                    }
                    break;
                case 5:
                    if (!(autocompletable instanceof UserAutocompletable)) {
                        autocompletable = null;
                    }
                    UserAutocompletable userAutocompletable = (UserAutocompletable) autocompletable;
                    if (userAutocompletable != null) {
                        integerOptionValue = new UserOptionValue(userAutocompletable.getUser());
                        stringOptionValue = integerOptionValue;
                    }
                    break;
                case 6:
                    if (!(autocompletable instanceof ChannelAutocompletable)) {
                        autocompletable = null;
                    }
                    ChannelAutocompletable channelAutocompletable = (ChannelAutocompletable) autocompletable;
                    if (channelAutocompletable != null) {
                        integerOptionValue = new ChannelOptionValue(channelAutocompletable.getChannel());
                        stringOptionValue = integerOptionValue;
                    }
                    break;
                case 7:
                    if (!(autocompletable instanceof RoleAutocompletable)) {
                        autocompletable = null;
                    }
                    RoleAutocompletable roleAutocompletable = (RoleAutocompletable) autocompletable;
                    if (roleAutocompletable != null) {
                        integerOptionValue = new RoleOptionValue(roleAutocompletable.getRole());
                        stringOptionValue = integerOptionValue;
                    }
                    break;
                case 8:
                    if (autocompletable instanceof RoleAutocompletable) {
                        stringOptionValue = new RoleOptionValue(((RoleAutocompletable) autocompletable).getRole());
                        break;
                    } else {
                        if (autocompletable instanceof UserAutocompletable) {
                            stringOptionValue = new UserOptionValue(((UserAutocompletable) autocompletable).getUser());
                        }
                        break;
                    }
                    break;
                case 9:
                    Number numberAsSafeNumberOrNull = asSafeNumberOrNull(parseNumber(value));
                    if (numberAsSafeNumberOrNull != null) {
                        numberOptionValue = new NumberOptionValue(numberAsSafeNumberOrNull);
                        stringOptionValue = numberOptionValue;
                    }
                    break;
                case 10:
                    Attachment<?> attachment = attachments.get(key);
                    if (attachment != null) {
                        String string3 = attachment.getUri().toString();
                        m.checkNotNullExpressionValue(string3, "it.uri.toString()");
                        numberOptionValue = new AttachmentOptionValue(string3);
                        stringOptionValue = numberOptionValue;
                    }
                    break;
            }
            if (stringOptionValue != null) {
                linkedHashMap.put(key, stringOptionValue);
            } else {
                Long snowflake = SnowflakeUtils.INSTANCE.toSnowflake(string2);
                if (snowflake != null) {
                    linkedHashMap.put(key, new SnowflakeOptionValue(snowflake.longValue()));
                } else {
                    linkedHashMap.put(key, new RawOptionValue(string));
                }
            }
        }
        return linkedHashMap;
    }

    public final String transformParameterSpannableString(String str) {
        if (str == null) {
            return null;
        }
        if (w.endsWith$default((CharSequence) w.trim(str).toString(), MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            return w.trim(str).toString();
        }
        if (!w.contains$default((CharSequence) str, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
            return str;
        }
        List listSplit$default = w.split$default((CharSequence) str, new char[]{MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR}, false, 0, 6, (Object) null);
        String str2 = (String) u.firstOrNull(listSplit$default);
        String string = str2 != null ? w.trim(str2).toString() : null;
        String strJoinToString$default = u.joinToString$default(listSplit$default.subList(1, listSplit$default.size()), ":", null, null, 0, null, null, 62, null);
        Objects.requireNonNull(strJoinToString$default, "null cannot be cast to non-null type kotlin.CharSequence");
        return a.y(string, ": ", w.trim(strJoinToString$default).toString());
    }

    private final Integer asSafeNumberOrNull(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (INSTANCE.isSafeNumber(Integer.valueOf(iIntValue))) {
            return Integer.valueOf(iIntValue);
        }
        return null;
    }

    private final Long asSafeNumberOrNull(Long l) {
        if (l == null) {
            return null;
        }
        long jLongValue = l.longValue();
        if (INSTANCE.isSafeNumber(Long.valueOf(jLongValue))) {
            return Long.valueOf(jLongValue);
        }
        return null;
    }
}

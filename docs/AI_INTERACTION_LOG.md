First prompt:

"Please write an algorithm under the TODO implement Gnome Sort Here comment in the SortingUtility class. Please use exact variable names from the pseudocode I will provide., be sure that it can handle the arrays of Comparable objects (gemeric implementation) and you may use the swap() method where appropriate. Please include comments for clarity. The pseudocode is as follows:
procedure gnomeSort(a[]):
pos := 0
while pos < length(a):
if (pos == 0 or a[pos] >= a[pos-1]):
pos := pos + 1
else:
swap a[pos] and a[pos-1]
pos := pos - "

Response: Plan: Implement Gnome Sort
Update only SortingUtility.gnomeSort in SortingUtility.java to match the README pseudocode exactly, preserving the required generic Comparable signature and pseudocode names a and pos. Keep the change isolated, add brief clarity comments, optionally reuse swap, then validate with project tooling so the Maven build still passes cleanly.
Steps
Review the required pseudocode in README.md and mirror gnomeSort(T[] a) with exact a and pos names.
Edit only SortingUtility.gnomeSort in SortingUtility.java, keeping public static <T extends Comparable<T>>.
Implement the loop and comparison flow exactly from pseudocode, using compareTo for a[pos] and a[pos - 1].
Use brief comments for the forward-move and swap-backtrack cases, and optionally call swap(...) instead of inline element exchange.
Validate the change with IDE/compiler warnings on SortingUtility.java, then run Maven verification such as mvn test from the project root.
Further Considerations
SortingUtilityTest.java is empty; Option A: compile only, Option B: add focused gnome-sort tests first.
Guard against the common pos == 0 boundary error noted in docs/AI_PROMPTING_GUIDE.md.
Draft for review: if desired, I can refine this into a stricter validation checklist for IntelliJ on Windows and Maven.
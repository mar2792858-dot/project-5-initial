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

Second Prompt: 

"Please implement cocktailShakerSort with the same guidelines, ensuring the variable names match exactly, keeping generics so it can handle arrays of Comparable objects, using existing swap(), and adding comments The pseudocode is as follows:
procedure cocktailShakerSort(a : list of sortable items) is
do
swapped := false
for each i in 0 to length(a) − 1 do:
if a[i] > a[i + 1] then
swap(a[i], a[i + 1])
swapped := true
end if
end for
if not swapped then
break do-while loop
end if
swapped := false
for each i in length(a) − 1 to 0 do:
if a[i] > a[i + 1] then
swap(a[i], a[i + 1])
swapped := true
end if
end for
while swapped
end procedure"

Response: 

"Plan: Add cocktailShakerSort
Implement cocktailShakerSort only in SortingUtility.java, mirroring the README pseudocode while preserving the exact names a, swapped, and i. Keep the existing generic Comparable signature, reuse swap(), add short clarifying comments, and translate the pseudocode’s pass bounds to safe Java indices so no a[i + 1] access can go out of range.
Steps
Review cocktailShakerSort requirements in README.md and SortingUtility.cocktailShakerSort.
Replace the TODO in SortingUtility.cocktailShakerSort with a do-while structure using swapped.
Use forward and backward passes with safe i bounds, still comparing adjacent a elements.
Call swap() for each out-of-order pair and add brief comments for each pass and early break.
Validate SortingUtility.java for compiler/IDE errors, then run Maven from pom.xml.
Further Considerations
For pseudocode fidelity, use Option A: exact pass logic with corrected bounds; Option B: add shrinking pass limits only if allowed.
Arrays of length 0 or 1 should exit naturally without extra complexity if loop bounds are chosen carefully.
If desired, this draft can be refined into a stricter Windows/IntelliJ validation checklist."


Note: For the responses, I included the AI plan. It also provided
an Acknowledgement of what it updated in the code, but I found
it to be wordy and redundant to what I requested, so I did not include it in the response.
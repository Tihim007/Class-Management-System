package Classes.sub;

import Classes.Section;

public class SectionManager {
    private Section[] Sections;

    public SectionManager(Section[] arr){
        Sections = arr;
    }

    public void addSection(Section sec){
        boolean flag = false;
        for (int i=0; i<Sections.length; i++){
            if(Sections[i] == null){
                Sections[i] = sec;
                flag = true;
                break;
            }
        }
        if (flag)
        System.out.println("New Section Added..");
        else
        System.out.println("Failed to add Section..");
    }
    public void deleteSection(Section sec){
        boolean flag = false;
        for (int i=0; i<Sections.length; i++){
            if(Sections[i] != null){
                if(Sections[i] == sec){
                    Sections[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Section deleted..");
        else
        System.out.println("Failed to delete Section..");
    }
    public Section getSection(char SecName){
        boolean flag = false;
        Section section = null;
        for (int i=0; i<Sections.length; i++){
            if(Sections[i] != null){
                if(Sections[i].getSectionName() == SecName){
                    section = Sections[i];
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Section found..");
        else
        System.out.println("Section not found..");

        return section;
    }

    
    public Section[] getSections() {
        return Sections;
    }

    public void setSections(Section[] sections) {
        Sections = sections;
    }
}

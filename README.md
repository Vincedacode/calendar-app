# 🗓️ Vincedacode's Calendar App

**Vincedacode's Calendar App** is a simple yet powerful Java console application that helps you manage your daily events with ease. Add, view, and track events with automatic cleanup of past dates — all through a clean text-based interface.

> ✅ Includes a ready-to-run JAR file: `calendarapp.jar`

---

## 🎯 Features

- ✅ **Add Events** – Enter date and description to save an event  
- ✅ **View Upcoming Events** – See what's ahead on your calendar  
- ✅ **Auto-Remove Past Events** – Missed events are automatically cleaned up  
- ✅ **Check Today’s Events** – Instantly know what’s planned for today  
- ✅ **Save & Load Events** – Events persist using Java serialization  
- ✅ **Simple Console UI** – Clear and beginner-friendly interface  

---

## 🛠 Requirements

- Java 8 or later  
- Command line terminal or any Java-supported IDE  

---

## 🚀 How to Run

### Option 1: Run the Pre-built JAR

```bash
java -jar calendarapp.jar
Option 2: Compile and Run from Source
Compile all Java files:

bash
Copy
Edit
javac CalenderApp/*.java
Run the main class:

bash
Copy
Edit
java CalenderApp.Main
🧾 How to Use
Launch the app

Choose an option:

Add new event

View all upcoming events

Check events scheduled for today

Exit the app

Event Format

Date input format: yyyy-MM-dd

Example: 2025-20-25

Data Persistence

Events are stored in events.txt using Java serialization

They are automatically loaded when the app starts

📂 File Structure
bash
Copy
Edit
CalenderApp/
├── Event.java              # Defines the Event class
├── Calender.java           # Contains core calendar functionality
├── Main.java               # Handles user interaction
├── events.txt              # Auto-generated saved events
└── CalendarAPp.jar # Compiled JAR (provided)
🔮 Possible Future Features

📅 Weekly/Monthly event view

🔔 Reminder system via CLI



👤 Author
Made with ❤️ by Vincedacode

“Organize your day, one event at a time.”

GitHub: @vincedacode

Enjoy staying organized!
Feedback, issues, and contributions are always welcome!

yaml
Copy
Edit

---

Let me know if you want:
- A `.gitignore` file
- Markdown badges (Java version, license, etc.)
- Auto-deploy setup or GitHub Pages summary (for GUI versions)
